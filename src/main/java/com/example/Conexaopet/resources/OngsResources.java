package com.example.Conexaopet.resources;
import com.example.Conexaopet.domain.Ongs;
import com.example.Conexaopet.services.OngsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/ongs")
public class OngsResources {

    @Autowired
    private OngsService service;

    @PostMapping
    public ResponseEntity<Ongs> insertOng(@RequestBody Ongs obj){
        Ongs ongSaved = service.insertOng(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ongSaved.getId()).toUri();

        return ResponseEntity.created(uri).body(ongSaved);
    }

    @GetMapping
    public ResponseEntity<List<Ongs>> findAll(){
        List<Ongs> list = service.findAll();

        return  ResponseEntity.ok().body(list);
    }
}
