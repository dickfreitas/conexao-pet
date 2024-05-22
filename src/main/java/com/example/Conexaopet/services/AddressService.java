package com.example.Conexaopet.services;

import com.example.Conexaopet.domain.Address;
import com.example.Conexaopet.domain.Ongs;
import com.example.Conexaopet.domain.Tutor;
import com.example.Conexaopet.dtos.UpdateAddressDTO;
import com.example.Conexaopet.repositories.AddressRepository;
import com.example.Conexaopet.repositories.OngsRepository;
import com.example.Conexaopet.repositories.TutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;
    @Autowired
    private OngsRepository ongsRepository;
    @Autowired
    private TutorRepository tutorRepository;

    public Address saveAddressOngs(String id , Address obj){
        return addOngAddress(obj , id);
    }

    public Address saveAddressTutor(String id , Address obj){
        return addTutorAddress(obj , id);
    }

    public Address updateAddress(String id , UpdateAddressDTO obj){
        Address addressResponse = repository.findById(id).orElseThrow(()-> new RuntimeException("Endereço não encontrado"));

        if(addressResponse == null){
            throw new RuntimeException("Endereço não cadastrado");
        }

        obj.getCep().ifPresent(addressResponse::setCep);
        obj.getState().ifPresent(addressResponse::setState);
        obj.getNumber().ifPresent(addressResponse::setNumber);
        obj.getNeighborhood().ifPresent(addressResponse::setNeighborhood);
        obj.getPublic_place().ifPresent(addressResponse::setPublic_place);
        obj.getCity().ifPresent(addressResponse::setCity);

        repository.save(addressResponse);

        return addressResponse;

    }

    private  Address addTutorAddress(Address obj , String id){
        Tutor tutor = tutorRepository.findById(id).orElseThrow(() -> new RuntimeException("Tutor não encontrado"));
        try{
            Address address = new Address();

            address.setCep(obj.getCep());
            address.setCity(obj.getCity());
            address.setNumber(obj.getNumber());
            address.setState(obj.getState());
            address.setNeighborhood(obj.getNeighborhood());
            address.setPublic_place(obj.getPublic_place());
            address.setTutor(tutor);
            return repository.save(address);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }

    }

    private  Address addOngAddress(Address obj , String id) {
        Ongs ong = ongsRepository.findById(id).orElseThrow(() -> new RuntimeException("Ong com o id" + id + "não encontada"));

        try {
            Address address = new Address();
            address.setCep(obj.getCep());
            address.setCity(obj.getCity());
            address.setNumber(obj.getNumber());
            address.setState(obj.getState());
            address.setNeighborhood(obj.getNeighborhood());
            address.setPublic_place(obj.getPublic_place());
            address.setOngs(ong);

            return repository.save(address);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

}
