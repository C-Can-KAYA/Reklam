package com.lastSoftware.FirstProfessionalProject.Web.Controller;

import com.lastSoftware.FirstProfessionalProject.Service.Interface.IFirma;
import com.lastSoftware.FirstProfessionalProject.Web.Request.FirmaBilgi;
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
@RequestMapping(path = "firma")
@Api(value = "firma endpointler", tags = "Firma")
public class FirmaController {

    @Autowired
    IFirma firma;

    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insert(@RequestBody FirmaBilgi firmaBilgi)
    {
        return new ResponseEntity<>(firma.firmaAdd(firmaBilgi), HttpStatus.OK);
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<Object> findAll()
    {
        return new ResponseEntity<>(firma.list(), HttpStatus.OK);
    }

    @PostMapping(path="/findById/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        return new ResponseEntity<>(firma.findById(id), HttpStatus.OK);
    }

    @PostMapping(path="/updateFirma")
    public ResponseEntity<Object> updateFirma(@RequestBody FirmaBilgi firmaBilgi){
        return new ResponseEntity<>(firma.updateFirma(firmaBilgi), HttpStatus.OK);
    }

    @PostMapping(path="/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(firma.deleteById(id), HttpStatus.OK);
    }

}
