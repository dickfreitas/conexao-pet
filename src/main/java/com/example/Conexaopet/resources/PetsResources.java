package com.example.Conexaopet.resources;

import com.example.Conexaopet.domain.Pets;
import com.example.Conexaopet.services.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController
@RequestMapping(value = "/pets")
public class PetsResources {
    @Autowired
    private PetsService service;

    @GetMapping
    public ResponseEntity<List<Pets>> findAll(){
        return service.findAll();


    }
}
