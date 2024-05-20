package com.example.Conexaopet.services;

import com.example.Conexaopet.domain.Ongs;
import com.example.Conexaopet.domain.Pets;
import com.example.Conexaopet.domain.Tutor;
import com.example.Conexaopet.dtos.ResponsePetsDTO;
import com.example.Conexaopet.dtos.ResponsePetsTutorDTO;
import com.example.Conexaopet.enuns.PetsStatus;
import com.example.Conexaopet.enuns.UserType;
import com.example.Conexaopet.repositories.OngsRepository;
import com.example.Conexaopet.repositories.PetsRepository;
import com.example.Conexaopet.repositories.TutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetsService {

    @Autowired
    private PetsRepository repository;

    @Autowired
    private OngsRepository ongsRepository;

    @Autowired
    private TutorRepository tutorRepository;

    public Pets insertPet(ResponsePetsDTO obj , String id){
            Ongs ong = ongsRepository.findById(id).orElseThrow(()-> new RuntimeException("Ong não encontrada"));
            return savePetOngs(obj , ong);

    }

    public Pets insertPetTutor(ResponsePetsTutorDTO obj , String id){
        Tutor tutor = tutorRepository.findById(id).orElseThrow(()-> new RuntimeException("Ong não encontrada"));
        return savePetTutor(obj , tutor);

    }

    private Pets savePetOngs(ResponsePetsDTO obj , Ongs ong){
        try{
            Pets pets = new Pets();
            pets.setName(obj.getName());
            pets.setAnimal(obj.getAnimal());
            pets.setSize(obj.getSize());
            pets.setWeight(obj.getWeight());
            pets.setAge(obj.getAge());
            pets.setDescription(obj.getDescription());
            pets.setStatus(PetsStatus.UNDER_ANALYSIS);
            pets.setType(UserType.ONG);
            pets.setOngs(ong);
            return repository.save(pets);
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    private Pets savePetTutor(ResponsePetsTutorDTO obj , Tutor tutor){
        try{
            Pets pets = new Pets();
            pets.setName(obj.getName());
            pets.setAnimal(obj.getAnimal());
            pets.setSize(obj.getSize());
            pets.setWeight(obj.getWeight());
            pets.setAge(obj.getAge());
            pets.setDescription(obj.getDescription());
            pets.setStatus(PetsStatus.UNDER_ANALYSIS);
            pets.setType(UserType.TUTOR);
            pets.setTutor(tutor);
            return repository.save(pets);
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    public ResponseEntity<List<Pets>> findAll() {
       List<Pets> list = repository.findAll();

        return ResponseEntity.ok().body(list);
    }
}
