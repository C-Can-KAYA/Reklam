package com.lastSoftware.FirstProfessionalProject.FileUpload.Controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping(path = "file")
@Api(value = "upload endpointler", tags = "File")
public class FileController {
/*    @Autowired
    private FileStorageService storageService;

    @PostMapping("/insert")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            FileDB fileDB =storageService.store(file);
            message = "Uploaded the file successfully: " + fileDB.getId();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/")
                    .path(dbFile.getId()).toUriString();

            return new ResponseFile(dbFile.getName(), fileDownloadUri, dbFile.getType(), dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Object> getFile(@PathVariable String id) {

        try {
            FileDB fileDB = storageService.getFile(id);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                    .body(fileDB.getData());
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseMessage> deletFileById(@PathVariable String id) {
        String message = "";
        message = storageService.deleteFileById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }*/
}
