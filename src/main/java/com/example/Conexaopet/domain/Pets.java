package com.example.Conexaopet.domain;

import com.example.Conexaopet.enuns.PetsStatus;
import com.example.Conexaopet.enuns.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tb_pets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Pets {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String animal;
    private String size;
    private Integer weight;
    private Integer age;
    private String description;
    private PetsStatus status;
    private UserType type;

    @ManyToOne
    @JoinColumn(name = "ongs_id")
    @JsonIgnore
    private Ongs ongs;

    @OneToOne
    @JoinColumn(name = "tutor_id")
    @JsonIgnore
    private Tutor tutor;

}
