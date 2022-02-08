package com.example.api_project.controller;


import com.example.api_project.entity.Equipe;
import com.example.api_project.entity.Joueur;
import com.example.api_project.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class EquipeController {

    @Autowired
    EquipeService equipeService;

    @GetMapping("/getEquipe")
    public ResponseEntity<List<Equipe>> getEquipe()
    {
        List<Equipe> equipes = equipeService.getEquipes();
        return new ResponseEntity<> (equipes, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addEquipe(@RequestBody Equipe equipe)
    {
        equipeService.addEquipe(equipe);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/deleteEquipe/{id}")
    public ResponseEntity<?> deleteEquipr(@PathVariable("id") Long id)
    {
        equipeService.deletequipe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/deleteEquipeByPay/{pay}")
    public ResponseEntity<List<Equipe>> deleteEquipeByPay(@PathVariable("pay") String name)
    {
        List<Equipe> equipes = equipeService.deleteEquipebypays(name);
        return new ResponseEntity<>(equipes,HttpStatus.OK);
    }
    @GetMapping("/getJoueurParEquipe")
    public ResponseEntity<Collection<Joueur>> getJoueurParEquipe(@PathVariable String nomEquipe){
       Collection<Joueur> joueurs =  equipeService.getJoueurParEquipe(nomEquipe);
       return new ResponseEntity<>(joueurs,HttpStatus.OK);
    }
}
