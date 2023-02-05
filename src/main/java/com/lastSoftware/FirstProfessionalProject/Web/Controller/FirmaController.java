package com.lastSoftware.FirstProfessionalProject.Web.Controller;

import com.lastSoftware.FirstProfessionalProject.Service.Interface.IFirma;
import com.lastSoftware.FirstProfessionalProject.Web.Request.FirmaBilgi;
import com.lastSoftware.FirstProfessionalProject.Web.Response.FirmaResponse;
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
@RequestMapping(path = "firma")
@Api(value = "firma endpointler", tags = "Firma")
public class FirmaController {
    @Autowired
    IFirma firma;
    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FirmaResponse> insert(@RequestBody FirmaBilgi firmaBilgi) throws Exception {
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
    public ResponseEntity<FirmaResponse> updateFirma(@RequestBody FirmaBilgi firmaBilgi) throws Exception {
        return new ResponseEntity<>(firma.updateFirma(firmaBilgi), HttpStatus.OK);
    }

    @PostMapping(path="/deleteById/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(firma.deleteById(id), HttpStatus.OK);
    }
}
