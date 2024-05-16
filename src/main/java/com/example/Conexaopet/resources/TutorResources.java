package com.example.Conexaopet.resources;

import com.example.Conexaopet.domain.Tutor;
import com.example.Conexaopet.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/tutor")
public class TutorResources {
    @Autowired
    private TutorService service;

    @PostMapping
    public ResponseEntity<Tutor> addTutor(@RequestBody Tutor obj){
        Tutor tutorSave = service.addTutor(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(tutorSave.getId()).toUri();

        return ResponseEntity.created(uri).body(tutorSave);
    }

}
