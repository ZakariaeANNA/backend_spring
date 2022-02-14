package com.example.api_project.entity;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;

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

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name="idEquipe")
    @JsonIgnoreProperties({"joueurs","matches"})
    Equipe equipe;
    
}