package com.example.Conexaopet.services;

import com.example.Conexaopet.domain.Address;
import com.example.Conexaopet.domain.Ongs;
import com.example.Conexaopet.repositories.AddressRepository;
import com.example.Conexaopet.repositories.OngsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;
    @Autowired
    private OngsRepository ongsRepository;

    public Address addAddressById(String id , Address obj){
        Ongs ong = ongsRepository.findById(id).orElseThrow(()->new RuntimeException("Ong com o id" + id + "não encontada"));

        try{
            Address address = new Address();
            address.setCep(obj.getCep());
            address.setCity(obj.getCity());
            address.setNumber(obj.getNumber());
            address.setState(obj.getState());
            address.setNeighborhood(obj.getNeighborhood());
            address.setPublic_place(obj.getPublic_place());
            address.setOngs(ong);

            return repository.save(address);
        }catch (EntityNotFoundException e ){
            throw new EntityNotFoundException(e.getMessage());
        }

    }
}
