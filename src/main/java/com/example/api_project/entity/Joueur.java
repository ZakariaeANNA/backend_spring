package com.example.api_project.entity;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idJoueur")
public class Joueur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idJoueur;

    @Column
    String nomJoueur;

    @Column
    String poste;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name="id_Equipe")
    @JsonBackReference("equipe")
    Equipe equipe;
}
