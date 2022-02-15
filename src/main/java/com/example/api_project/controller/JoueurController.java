package com.example.api_project.controller;

import com.example.api_project.dto.Joueurdto;
import com.example.api_project.entity.Equipe;
import com.example.api_project.entity.Joueur;
import com.example.api_project.service.JoueurService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.nimbusds.jose.shaded.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {

    @Autowired
    JoueurService joueurService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/all")
    public ResponseEntity<List<Joueurdto>> getJoueurs(){
        List<Joueurdto> joueurs  = joueurService.getJoueurs().stream().map(joueur -> modelMapper.map(joueur, Joueurdto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(joueurs, HttpStatus.OK);

    }
    @PostMapping("/add")
    public ResponseEntity<?> addJoueur(@RequestBody Joueur joueur)
    {
        joueurService.addJoueur(joueur);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJoueur(@PathVariable("id") Long id)
    {
        joueurService.deleteJoueur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/JoueurParposteequipe/{poste}/{nomequipe}")
    public ResponseEntity<List<Joueur>> JoueurParposteEquipe(@PathVariable("poste") String poste, @PathVariable("nomequipe") String nomequipe){
        List<Joueur> joueurs = joueurService.JoueurParposteEquipe(poste,nomequipe);
        return new ResponseEntity<>(joueurs,HttpStatus.OK);
    }
}
