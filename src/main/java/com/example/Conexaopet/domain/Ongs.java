package com.example.Conexaopet.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_ongs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ongs {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String corporate_name;
    private String email;
    private String contact;
    private String address;
}
