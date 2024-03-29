package uz.backweb.resource;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.backweb.fileupload.FileService;
import uz.backweb.models.ImageNews;
import uz.backweb.models.News;
import uz.backweb.sevice.NewsService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import static org.springframework.http.MediaType.parseMediaType;

@Log4j2
@RequestMapping("/api/news/")
@RestController
@RequiredArgsConstructor
public class NewsResource {
    @Autowired
    final NewsService newsService;
    @Autowired
    final FileService fileService;


    @GetMapping("get")
    private ResponseEntity<List<News>> getAll() {
        return ResponseEntity.ok().body(newsService.getAllActive());
    }

    @PostMapping("save")
    private ResponseEntity<News> save(@RequestBody News news) {
        return ResponseEntity.ok().body(newsService.save(news));
    }

    @PutMapping("remove")
    private ResponseEntity<News> remove(@RequestParam("id") String id){
        return ResponseEntity.ok().body(newsService.remote(id));
    }

    @PostMapping(value = "upload")
    public ResponseEntity<?> uploadAndDownload(@RequestParam("id") String id,
                                               @RequestParam("file") MultipartFile file) {

        News news = newsService.getById(id);
        String filetype = file.getOriginalFilename();
        news.setImagepath(news.getId() +"."+ filetype.substring(filetype.lastIndexOf(".") + 1));
        newsService.save(news);
        try {

            return ResponseEntity.ok(fileService.storeFile(file, news.getImagepath(), "news"));
        } catch (Exception e) {
            return ResponseEntity.ok("Error while processing file");
        }
    }


    @GetMapping("download/news/{filename:.+}")
    public ResponseEntity<?> downloadFile(@PathVariable("filename") String filename,
                                          HttpServletRequest request) throws IOException {

        Resource fileResource = fileService.getFile(filename, "news");

        String contentType = null;

        try {
            contentType = request.getServletContext().getMimeType(fileResource.getFile().getAbsolutePath());
        } catch (IOException e) {
            log.error("Could not determine file type.");
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileResource.getFilename() + "\"")
                .body(fileResource);

    }



    @GetMapping("download/imagenews/{filename:.+}")
    public ResponseEntity<?> imagenewsdownloadFile(@PathVariable("filename") String filename, HttpServletRequest request) {

        Resource fileResource = fileService.getFile(filename, "imagenews");

        String contentType = null;

        try {
            contentType = request.getServletContext().getMimeType(fileResource.getFile().getAbsolutePath());
        } catch (IOException e) {
            log.error("Could not determine file type.");
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileResource.getFilename() + "\"")
                .body(fileResource);

    }


    @PostMapping(value = "imagenewsupload")
    public ResponseEntity<?> imagenewsuploadFile(
            @RequestParam(value = "id") String id,
            @RequestParam("file") MultipartFile file) throws IOException {

        News news = newsService.getById(id);

        String filetype = file.getOriginalFilename();
        Random random = new Random();
        int min = 0;
        int max = 10000;
        int randomNumber = random.nextInt(max + 1 - min) + min;
        String filename = String.valueOf(randomNumber) + "." + filetype.substring(filetype.lastIndexOf(".") + 1);

        filename = filename.replace("'", "");
        ImageNews imageNews = new ImageNews();
        imageNews.setImagepath(filename);
        news.addImage(imageNews);
        newsService.save(news);


        try {

            return ResponseEntity.ok(fileService.storeFile(file, filename, "imagenews"));
        } catch (Exception e) {
            return ResponseEntity.ok("Error while processing file");
        }
    }





}
