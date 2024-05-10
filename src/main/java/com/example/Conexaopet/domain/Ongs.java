package com.example.Conexaopet.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_ongs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Ongs {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String corporate_name;
    private String email;
    private String contact;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "ongs")
    private List<Pets> pets = new ArrayList<>();
}
