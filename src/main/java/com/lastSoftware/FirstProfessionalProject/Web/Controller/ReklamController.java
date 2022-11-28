package com.lastSoftware.FirstProfessionalProject.Web.Controller;

import com.lastSoftware.FirstProfessionalProject.Entity.FileDB;
import com.lastSoftware.FirstProfessionalProject.Service.FileStorageService;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.IReklam;
import com.lastSoftware.FirstProfessionalProject.Web.Response.ResponseMessage;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping(path = "reklam")
@Api(value = "reklam endpointler", tags = "Reklam")
public class ReklamController {

    @Autowired
    IReklam reklam;

    @Autowired
    private FileStorageService storageService;

    @PostMapping(path = "/insert/{firma}")
    public ResponseEntity<Object> insert(@RequestParam("multipartFile") MultipartFile multipartFile,@PathVariable("firma") Long firma) {
        return new ResponseEntity<>(reklam.add(multipartFile,firma), HttpStatus.OK);
    }

    @PostMapping(path="/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable String id){
        return new ResponseEntity<>(reklam.deleteById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/findById/{id}")
    public ResponseEntity<Object> getFile(@PathVariable Long id) {
        return new ResponseEntity<>(reklam.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<Object> findAll()
    {
        return new ResponseEntity<>(reklam.list(), HttpStatus.OK);
    }

    @GetMapping("/findByIdFile/{id}")
    public ResponseEntity<Object> getfindByFile(@PathVariable String id) {

        try {
            FileDB fileDB = storageService.getFile(id);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "ekli; dosya adı=\"" + fileDB.getName() + "\"")
                    .body(fileDB.getData());
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(e.getMessage()));
        }
    }

}
