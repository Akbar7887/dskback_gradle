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
import uz.backweb.models.ImageCatalog;
import uz.backweb.sevice.ImageCatalogService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.parseMediaType;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/imagecatalog/")
public class ImageCatalogResource {

    @Autowired
    final ImageCatalogService imageCatalogService;
    final FileService fileService;

    @GetMapping("get")
    private ResponseEntity<List<ImageCatalog>> getAll() {
        return ResponseEntity.ok().body(imageCatalogService.getAll());
    }

    @GetMapping("getbyid")
    private ResponseEntity<List<ImageCatalog>> getById(@RequestParam("id") String id) {
        return ResponseEntity.ok().body(imageCatalogService.getByCatalogId(id));
    }


    @PostMapping(value = "upload")
    public ResponseEntity<?> uploadAndDownload(
            @RequestParam(value = "id") String id,
            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile file) {

        ImageCatalog imageCatalog = imageCatalogService.getById(id);
        imageCatalog.setDescription(description);
        imageCatalogService.postwithImage(file.getOriginalFilename(), id, imageCatalog);


        return ResponseEntity.ok(fileService.storeFile(file, imageCatalog.getImagepath(), "catalogs"));

    }


    @GetMapping("download/catalogs/{filename:.+}")
    public ResponseEntity<?> downloadFile(@PathVariable("filename") String filename, HttpServletRequest request) throws IOException {

        Resource fileResource = fileService.getFile(filename, "catalogs");

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



//    @PutMapping("/webimage")
//    public ResponseEntity<ImageData> webImage(@RequestParam("web") String web, @RequestParam("id") String id) {
//        return ResponseEntity.ok().body(imageCatalogService.onweb(Boolean.parseBoolean(web), id));
//    }
}
