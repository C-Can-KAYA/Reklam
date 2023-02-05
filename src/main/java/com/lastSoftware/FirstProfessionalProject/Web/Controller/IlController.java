package com.lastSoftware.FirstProfessionalProject.Web.Controller;

import com.lastSoftware.FirstProfessionalProject.Service.Interface.IIller;
import com.lastSoftware.FirstProfessionalProject.Web.Request.IlRequest;
import com.lastSoftware.FirstProfessionalProject.Web.Response.IlResponse;
import com.lastSoftware.FirstProfessionalProject.Web.Response.MessageResponse;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "il")
@Api(value = "il endpointler", tags = "Il")
public class IlController {
    @Autowired
    IIller il;

    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IlResponse> insert(@RequestBody IlRequest ilRequest) throws Exception {
        return new ResponseEntity<>(il.addIl(ilRequest), HttpStatus.OK);
    }

    @PostMapping(path = "/deleteById/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(il.deleteById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(il.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IlResponse> update(@RequestBody IlRequest ilRequest) throws Exception {
        return new ResponseEntity<>(il.ilUpdate(ilRequest), HttpStatus.OK);
    }
}
