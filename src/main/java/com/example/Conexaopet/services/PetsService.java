package com.example.Conexaopet.services;

import com.example.Conexaopet.domain.Pets;
import com.example.Conexaopet.repositories.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetsService {

    @Autowired
    private PetsRepository repository;

    public Pets insertPet(Pets pet){return  repository.save(pet);}
}
