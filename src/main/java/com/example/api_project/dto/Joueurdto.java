package com.example.api_project.dto;

import java.util.HashSet;
import java.util.Set;

import com.example.api_project.entity.Equipe;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
public class Joueurdto {
    Long idJoueur;
    String nomJoueur;
    String poste;

    @JsonIgnoreProperties({"joueurs","matches"})
    Equipe equipe;
}