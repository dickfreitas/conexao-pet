package com.example.Conexaopet.resources;

import com.example.Conexaopet.domain.Pets;
import com.example.Conexaopet.domain.Tutor;
import com.example.Conexaopet.dtos.ResponsePetsDTO;
import com.example.Conexaopet.dtos.ResponsePetsTutorDTO;
import com.example.Conexaopet.services.PetsService;
import com.example.Conexaopet.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tutor")
public class TutorResources {
    @Autowired
    private TutorService service;

    @Autowired
    private PetsService petsServices;

    @PostMapping
    public ResponseEntity<Tutor> addTutor(@RequestBody Tutor obj){
        Tutor tutorSave = service.addTutor(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(tutorSave.getId()).toUri();

        return ResponseEntity.created(uri).body(tutorSave);
    }

    @PostMapping(value = "/pets/{id}")
    public ResponseEntity<Pets> addPets(@RequestBody ResponsePetsTutorDTO pet , @PathVariable String id ){
        Pets petsSaved = petsServices.insertPetTutor(pet , id);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(petsSaved.getId()).toUri();

        return ResponseEntity.created(uri).body(petsSaved);

    }

    @GetMapping
    public ResponseEntity<List<Tutor>> getTutor(){
        List<Tutor> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

}
