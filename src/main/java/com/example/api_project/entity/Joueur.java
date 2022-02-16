package com.example.api_project.entity;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Joueur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idJoueur;

    @Column
    String nomJoueur;

    @Column
    String poste;

    @JsonBackReference("equipe")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name="idEquipe")
    @JsonIgnoreProperties({"joueurs","matches"})
    Equipe equipe;
    
}
