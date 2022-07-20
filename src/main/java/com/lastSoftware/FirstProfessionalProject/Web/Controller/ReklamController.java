package com.lastSoftware.FirstProfessionalProject.Web.Controller;

import com.lastSoftware.FirstProfessionalProject.Implementation.Interface.IReklam;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping(path = "reklam")
@Api(value = "reklam endpointler", tags = "Reklam")
public class ReklamController {

    @Autowired
    IReklam reklam;

    @PostMapping(path = "/insert", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> insert(@RequestParam("file") MultipartFile reklamBilgi) {
        return new ResponseEntity<>(reklam.add(reklamBilgi), HttpStatus.OK);
    }

    @PostMapping(path="/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable String id){
        return new ResponseEntity<>(reklam.deleteById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<Object> findAll()
    {
        return new ResponseEntity<>(reklam.list(), HttpStatus.OK);
    }

}
