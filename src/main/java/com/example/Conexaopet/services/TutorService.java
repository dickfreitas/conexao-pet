package com.example.Conexaopet.services;

import com.example.Conexaopet.domain.Tutor;
import com.example.Conexaopet.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public Tutor addTutor(Tutor tutor){
        return repository.save(tutor);
    }

    public List<Tutor> findAll() {
        return repository.findAll();
    }
}
