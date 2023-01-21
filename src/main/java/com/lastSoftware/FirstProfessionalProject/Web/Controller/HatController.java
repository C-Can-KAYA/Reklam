package com.lastSoftware.FirstProfessionalProject.Web.Controller;

import com.lastSoftware.FirstProfessionalProject.Entity.Hat;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.IHat;
import com.lastSoftware.FirstProfessionalProject.Web.Request.HatRequest;
import com.lastSoftware.FirstProfessionalProject.Web.Response.MessageResponse;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "hat")
@Api(value = "hat endpointler", tags = "Hat")
public class HatController {
    @Autowired
    IHat hat;

    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> insert(@RequestBody HatRequest hatRequest) {
        return new ResponseEntity<>(hat.hatAdd(hatRequest), HttpStatus.OK);
    }

    @PostMapping(path = "/deleteById/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(hat.deleteById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(hat.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> update(@RequestBody HatRequest hatRequest) {
        return new ResponseEntity<>(hat.updateHat(hatRequest), HttpStatus.OK);
    }

    @GetMapping(path = "/findByNumberPlate/{number}")
    public ResponseEntity<List<Hat>> findByNumberPlate(@PathVariable Integer number) {
        return new ResponseEntity<>(hat.findByPlateNumber(number), HttpStatus.OK);
    }
}
