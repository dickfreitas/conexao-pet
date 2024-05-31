package com.example.Conexaopet.resources;
import com.example.Conexaopet.domain.Ongs;
import com.example.Conexaopet.domain.Pets;
import com.example.Conexaopet.dtos.ResponsePetsDTO;
import com.example.Conexaopet.services.OngsService;
import com.example.Conexaopet.services.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/ongs")
public class OngsResources {

    @Autowired
    private OngsService service;

    @Autowired
    private PetsService petsService;

    @PostMapping
    public ResponseEntity<Ongs> insertOng(@RequestBody Ongs obj){
        String password = new BCryptPasswordEncoder().encode(obj.getPassword());
        Ongs user  = new Ongs (obj.getCorporate_name(), obj.getEmail() , obj.getContact() , password);
        Ongs ongSaved = service.insertOng(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ongSaved.getId()).toUri();

        return ResponseEntity.created(uri).body(ongSaved);
    }
    @PostMapping(value = "/pets/{id}")
    public ResponseEntity<Pets> addPets(@RequestBody ResponsePetsDTO pet , @PathVariable String id ){
        Pets petsSaved = petsService.insertPet(pet, id);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(petsSaved.getId()).toUri();

        return ResponseEntity.created(uri).body(petsSaved);

    }

    @GetMapping
    public ResponseEntity<List<Ongs>> findAll(){
        List<Ongs> list = service.findAll();

        return  ResponseEntity.ok().body(list);
    }




}
