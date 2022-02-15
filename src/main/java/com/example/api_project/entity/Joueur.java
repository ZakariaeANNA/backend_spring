package com.example.api_project.entity;


import com.fasterxml.jackson.annotation.*;
<<<<<<< HEAD
=======
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
>>>>>>> d2a82b147b1c6b43291831c421d3b5bbae46047a
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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
<<<<<<< HEAD
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name="id_Equipe")
    @JsonBackReference("equipe")
=======


    @JsonBackReference("equipe")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name="idEquipe")
<<<<<<< HEAD
=======
    @JsonIgnoreProperties({"joueurs","matches"})
>>>>>>> d2a82b147b1c6b43291831c421d3b5bbae46047a
>>>>>>> 7bc3de2c00b3ffc91cfcde9415cfd72c27412ef8
    Equipe equipe;
    
}