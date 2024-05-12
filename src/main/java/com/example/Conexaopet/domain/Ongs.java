package com.example.Conexaopet.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_ongs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ongs {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String corporate_name;
    private String email;
    private String contact;
    private String password;

    @OneToMany(mappedBy = "ongs")
    private List<Address> address = new ArrayList<>();

    @OneToMany(mappedBy = "ongs")
    private List<Pets> pets = new ArrayList<>();

}
