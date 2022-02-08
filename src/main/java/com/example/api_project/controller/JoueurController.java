package com.example.api_project.controller;

import com.example.api_project.entity.Joueur;
import com.example.api_project.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoueurController {
    @Autowired
    JoueurService joueurService;

    @GetMapping("/getJoueurs")
    public ResponseEntity<List<Joueur>> getJoueurs()
    {
        List<Joueur> joueurs  = joueurService.getJoueurs();
        return new ResponseEntity<>(joueurs, HttpStatus.OK);
    }
    @PostMapping("/addJoueur")
    public ResponseEntity<?> addJoueur(@RequestBody Joueur joueur)
    {
        joueurService.addJoueur(joueur);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/deleteJoueur/{id}")
    public ResponseEntity<?> deleteJoueur(@PathVariable("id") Long id)
    {
        joueurService.deleteJoueur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
