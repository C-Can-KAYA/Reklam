package com.lastSoftware.FirstProfessionalProject.Web.Controller;

import com.lastSoftware.FirstProfessionalProject.Service.Interface.IMinibus;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping(path = "minibus")
@Api(value = "minibus endpointler", tags = "Minibus")
public class MinibusController {

    @Autowired
    IMinibus minibus;

    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insert(@RequestBody MinibusBilgi minibusBilgi)
    {
        return new ResponseEntity<>(minibus.minibusAdd(minibusBilgi), HttpStatus.OK);
    }

    @PostMapping(path="/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(minibus.deleteById(id), HttpStatus.OK);
    }

    @PostMapping(path="/hatList/{il}")
    public ResponseEntity<Object> hatList(@PathVariable String il){
        return new ResponseEntity<>(minibus.hatList(il), HttpStatus.OK);
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<Object> findAll()
    {
        return new ResponseEntity<>(minibus.minibusList(), HttpStatus.OK);
    }

    @GetMapping(path = "/findByNumberPlate/{number}")
    public ResponseEntity<Object> findByNumberPlate(@PathVariable String number)
    {
        return new ResponseEntity<>(minibus.findByNumberPlate(number), HttpStatus.OK);
    }

    @GetMapping(path = "/findById/{number}")
    public ResponseEntity<Object> findById(@PathVariable Long number)
    {
        return new ResponseEntity<>(minibus.findById(number), HttpStatus.OK);
    }

    @GetMapping(path = "/findAll/il")
    public ResponseEntity<Object> findAllIl()
    {
        return new ResponseEntity<>(minibus.ilList(), HttpStatus.OK);
    }
}
