package com.example.Conexaopet.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String cep;
    private String state;
    private String city;
    private String public_place;
    private String neighborhood;
    private String number;

    @OneToOne(mappedBy = "address")
    private User user;

    @OneToOne(mappedBy = "address")
    private Tutor tutor;

    @OneToMany(mappedBy = "address")
    private List<Ongs> ongs = new ArrayList<>();


}
