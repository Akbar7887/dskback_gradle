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
import uz.backweb.models.Make;
import uz.backweb.sevice.MakeService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.parseMediaType;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/make/")
public class MakeResource {

    @Autowired
    final MakeService makeService;
    final FileService fileService;


    @GetMapping("get")
    private ResponseEntity<List<Make>> getAll() {
        return ResponseEntity.ok().body(makeService.getAll());
    }

    @PostMapping("save")
    private ResponseEntity<Make> save(@RequestBody Make make) {
        return ResponseEntity.ok().body(makeService.save(make));
    }

    @PostMapping(value = "upload")
    public ResponseEntity<?> uploadAndDownload(@RequestParam("id") String id,
                                               @RequestParam("file") MultipartFile file) {
        try {

            Make make = makeService.getById(id);
            String filetype = file.getOriginalFilename();
            make.setImagepath(make.getId() + "." + filetype.substring(filetype.lastIndexOf(".") + 1));
            makeService.save(make);

            return ResponseEntity.ok(fileService.storeFile(file, make.getImagepath(), "makes"));
        } catch (Exception e) {
            return ResponseEntity.ok("Error while processing file");
        }
    }


    @GetMapping("download/makes/{filename:.+}")
    public ResponseEntity<?> downloadFile(@PathVariable("filename") String filename, HttpServletRequest request) throws IOException {

        Resource fileResource = fileService.getFile(filename, "makes");

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
}
