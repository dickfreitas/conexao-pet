package com.example.Conexaopet.services;

import com.example.Conexaopet.domain.Ongs;
import com.example.Conexaopet.domain.Pets;
import com.example.Conexaopet.enuns.PetsStatus;
import com.example.Conexaopet.enuns.UserType;
import com.example.Conexaopet.repositories.OngsRepository;
import com.example.Conexaopet.repositories.PetsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetsService {

    @Autowired
    private PetsRepository repository;

    @Autowired
    private OngsRepository ongsRepository;

    public Pets insertPet(Pets obj , String id){
        Ongs ong = ongsRepository.findById(id).orElseThrow(()-> new RuntimeException("Ong não encontrada"));

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

        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
