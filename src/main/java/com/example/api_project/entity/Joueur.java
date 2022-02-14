package com.example.api_project.entity;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.Data;
<<<<<<< HEAD
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Joueur  {
=======
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;

@Entity
@Data
public class Joueur{
>>>>>>> 89e68e23bb0ce4316eadd28e99d9f44bf1e3989f
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
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name="idEquipe")
    @JsonIgnoreProperties({"joueurs","matches"})
>>>>>>> 89e68e23bb0ce4316eadd28e99d9f44bf1e3989f
    Equipe equipe;
    
}