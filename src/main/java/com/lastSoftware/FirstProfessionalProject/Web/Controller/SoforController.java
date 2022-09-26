package com.lastSoftware.FirstProfessionalProject.Web.Controller;


import com.lastSoftware.FirstProfessionalProject.Service.Interface.ISofor;
import com.lastSoftware.FirstProfessionalProject.Web.Request.SoforBilgi;
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
@RequestMapping(path = "sofor")
@Api(value = "sofor endpointler", tags = "Sofor")
public class SoforController
{
    @Autowired
    ISofor sofor;

    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insert(@RequestBody SoforBilgi soforBilgi)
    {
        return new ResponseEntity<>(sofor.soforAdd(soforBilgi), HttpStatus.OK);
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<Object> findAll()
    {
        return new ResponseEntity<>(sofor.soforList(), HttpStatus.OK);
    }

    @PostMapping(path="/findById/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        return new ResponseEntity<>(sofor.findById(id), HttpStatus.OK);
    }

    @PutMapping(path="/updateSofor")
    public ResponseEntity<Object> updateSofor(@RequestBody SoforBilgi soforBilgi){
        return new ResponseEntity<>(sofor.updateSofor(soforBilgi), HttpStatus.OK);
    }

    @PostMapping(path="/findByTckn/{tckn}")
    public ResponseEntity<Object> findByTckn(@PathVariable Long tckn){
        return new ResponseEntity<>(sofor.findByTckn(tckn), HttpStatus.OK);
    }

    @PostMapping(path="/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(sofor.deleteById(id), HttpStatus.OK);
    }

    @PostMapping(path="/deleteByTckn/{tckn}")
    public ResponseEntity<Object> deleteByTckn(@PathVariable Long tckn){
        return new ResponseEntity<>(sofor.deleteByTckn(tckn), HttpStatus.OK);
    }
}
