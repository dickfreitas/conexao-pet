package com.example.Conexaopet.resources;


import com.example.Conexaopet.domain.Ongs;
import com.example.Conexaopet.domain.Pets;
import com.example.Conexaopet.services.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/pets")
public class PetsResources {

    @Autowired
    private PetsService service;

    @PostMapping
    public ResponseEntity<Pets> insertPets(@RequestBody Pets obj){
        Pets petsSaved = service.insertPet(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(petsSaved.getId()).toUri();

        return ResponseEntity.created(uri).body(petsSaved);
    }
}
