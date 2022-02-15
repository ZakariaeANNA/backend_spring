package com.example.api_project.controller;

import com.example.api_project.entity.Joueur;
import com.example.api_project.service.JoueurService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD

import java.util.HashMap;
=======
import java.util.Arrays;
import java.util.HashSet;
>>>>>>> d2a82b147b1c6b43291831c421d3b5bbae46047a
import java.util.List;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {

    @Autowired
    JoueurService joueurService;


    @GetMapping("/all")
    public ResponseEntity<List<Joueur>> getJoueurs(){
        List<Joueur> joueurs  = joueurService.getJoueurs();
        System.out.println(""+joueurs.size());
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
