package com.example.Conexaopet.services;

import com.example.Conexaopet.domain.Ongs;
import com.example.Conexaopet.repositories.OngsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OngsService {
    @Autowired
    private OngsRepository repository;

    public Ongs insertOng(Ongs ong){
        return repository.save(ong);
    }

    public List<Ongs> findAll(){
        return repository.findAll();
    }

}
