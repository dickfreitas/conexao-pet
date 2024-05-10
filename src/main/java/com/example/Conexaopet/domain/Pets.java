package com.example.Conexaopet.domain;

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
    private String type;
    private String size;
    private Integer weight;
    private Integer age;
    private String description;
    private String status;


    @ManyToOne
    @JoinColumn(name = "ongs_id")
    private Ongs ongs;

    @OneToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

}
