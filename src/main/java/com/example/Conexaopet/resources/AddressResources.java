package com.example.Conexaopet.resources;

import com.example.Conexaopet.domain.Address;
import com.example.Conexaopet.dtos.UpdateAddressDTO;
import com.example.Conexaopet.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/address")
public class AddressResources {
    @Autowired
    private AddressService service;

    @PostMapping(value = "ongs/{id}")
    public ResponseEntity<Address> addAddressById(@PathVariable String id , @RequestBody Address obj){
        Address address = service.saveAddressOngs(id , obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(address.getId()).toUri();

        return ResponseEntity.created(uri).body(address);


    }
    @PostMapping(value = "tutor/{id}")
    public ResponseEntity<Address> addAddressTutor(@PathVariable String id , @RequestBody Address obj){
        Address address = service.saveAddressTutor(id , obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(address.getId()).toUri();

        return ResponseEntity.created(uri).body(address);


    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable String id , @RequestBody UpdateAddressDTO obj){
         Address address = service.updateAddress(id , obj);

        return ResponseEntity.ok().body(address);


    }

}
