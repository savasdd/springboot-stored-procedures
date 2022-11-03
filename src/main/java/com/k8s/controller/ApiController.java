package com.k8s.controller;

import com.k8s.model.Birim;
import com.k8s.service.BirimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ApiController {

    @Autowired
    private BirimService service;

    @Transactional
    @PostMapping("/birims")
    public ResponseEntity<Birim> create(@RequestBody Birim dto) {
        return new ResponseEntity<>(service.getBirim().create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/birims")
    public ResponseEntity<List<Birim>> getAll() {
        return new ResponseEntity<>(service.getBirim().getAll(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/birims/list")
    public ResponseEntity<List<Birim>> getBirimList() {
        return new ResponseEntity<>(service.getBirim().get_birim_list_function(), HttpStatus.OK);
    }


    @GetMapping("/birims/{yil}")
    public ResponseEntity<Integer> getByYear(@PathVariable int yil) {
        return new ResponseEntity<>(service.getBirim().getByYear(yil), HttpStatus.OK);
    }

    @GetMapping("/birims/sum")
    public ResponseEntity<Integer> getSum(@RequestParam("ad") String ad) {
        return new ResponseEntity<>(service.getBirim().getSumCount(ad), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/birims/create")
    public ResponseEntity<?> createProcedure(@RequestBody Birim dto) {
        service.getBirim().createProcedure(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Transactional
    @PutMapping("/birims/update/{id}")
    public ResponseEntity<?> updateProcedure(@PathVariable String id, @RequestBody Birim dto) {
        service.getBirim().updateProcedure(id, dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Transactional
    @DeleteMapping("/birims/delete/{id}")
    public ResponseEntity<?> deleteProcedure(@PathVariable String id) {
        service.getBirim().deleteProcedure(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
