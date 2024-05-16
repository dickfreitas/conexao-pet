package com.example.Conexaopet.dtos;

import com.example.Conexaopet.domain.Ongs;
import com.example.Conexaopet.domain.Pets;
import com.example.Conexaopet.enuns.PetsStatus;
import com.example.Conexaopet.enuns.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponsePetsDTO {
    private String name;
    private String animal;
    private String size;
    private Integer weight;
    private Integer age;
    private String description;
    private PetsStatus status;
    private UserType type;
    private Ongs ongs;

}
