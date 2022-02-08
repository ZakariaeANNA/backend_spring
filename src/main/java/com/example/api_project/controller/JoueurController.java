package com.example.api_project.controller;

import com.example.api_project.entity.Joueur;
import com.example.api_project.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {
    @Autowired
    JoueurService joueurService;

    @GetMapping("/all")
    public ResponseEntity<List<Joueur>> getJoueurs()
    {
        List<Joueur> joueurs  = joueurService.getJoueurs();
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
}
