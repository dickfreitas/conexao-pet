package com.example.Conexaopet.dtos;

import com.example.Conexaopet.domain.Address;
import com.example.Conexaopet.domain.Pets;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OngsDTO {
    private String corporate_name;
    private String email;
    private String contact;
    private String password;
    private String entity;
    private List<Address> address = new ArrayList<>();
    private List<Pets> pets = new ArrayList<>();
}
