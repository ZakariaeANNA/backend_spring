package com.example.api_project.dto;

import com.example.api_project.entity.Arbitre;
import com.example.api_project.entity.Equipe;
import com.example.api_project.entity.Stade;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Data
public class Matchedto {

    Long idMatch;
    Date dateMatch;
    Date heureMatch;

    @JsonIgnoreProperties({"Matches","matches"})
    Arbitre arbitre;

    @JsonIgnoreProperties({"matches"})
    Stade stade;

    Collection<Equipe> equipes;
}
