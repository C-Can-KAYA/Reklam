package com.lastSoftware.FirstProfessionalProject.Web.Controller;

import com.lastSoftware.FirstProfessionalProject.Entity.Minibus;
import com.lastSoftware.FirstProfessionalProject.Service.Interface.IMinibus;
import com.lastSoftware.FirstProfessionalProject.Web.Request.MinibusBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Request.ReklamGuncelle;
import com.lastSoftware.FirstProfessionalProject.Web.Response.MessageResponse;
import com.lastSoftware.FirstProfessionalProject.Web.Response.ReklamResponseNumberPlate;
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
@RequestMapping(path = "minibus")
@Api(value = "minibus endpointler", tags = "Minibus")
public class MinibusController {
    @Autowired
    IMinibus minibus;
    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Minibus> insert(@RequestBody MinibusBilgi minibusBilgi) throws Exception {
        return new ResponseEntity<>(minibus.minibusAdd(minibusBilgi), HttpStatus.OK);
    }

    @PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Minibus>> update(@RequestBody MinibusBilgi minibusBilgi) throws Exception {
        return new ResponseEntity<>(minibus.minibusUpdate(minibusBilgi), HttpStatus.OK);
    }

    @PostMapping(path = "/guncel", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateGuncel(@RequestBody ReklamGuncelle reklamGuncelle) throws Exception {
        return new ResponseEntity<>(minibus.minibusReklamGuncelle(reklamGuncelle), HttpStatus.OK);
    }

    @PostMapping(path = "/deleteById/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(minibus.deleteById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/hatList/{il}")
    public ResponseEntity<Object> hatList(@PathVariable String il) {
        return new ResponseEntity<>(minibus.hatList(il.toUpperCase()), HttpStatus.OK);
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(minibus.minibusList(), HttpStatus.OK);
    }

    @GetMapping(path = "/findByNumberPlate/{number}")
    public ResponseEntity<List<ReklamResponseNumberPlate>> findByNumberPlate(@PathVariable String number) {
        return new ResponseEntity<List<ReklamResponseNumberPlate>>(minibus.findByNumberPlate(number), HttpStatus.OK);
    }

    @GetMapping(path = "/findById/{number}")
    public ResponseEntity<Object> findById(@PathVariable Long number) throws Exception {
        return new ResponseEntity<>(minibus.findById(number), HttpStatus.OK);
    }

    @GetMapping(path = "/findAll/il")
    public ResponseEntity<Object> findAllIl() {
        return new ResponseEntity<>(minibus.ilList(), HttpStatus.OK);
    }
}
