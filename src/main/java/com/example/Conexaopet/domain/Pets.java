package com.example.Conexaopet.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_pets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pets {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String type;
    private String size;
    private Integer weight;
    private Integer age;
    private String description;
    private String status;



}
