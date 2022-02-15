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
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    EquipeService equipeService;

    @GetMapping("/all")
    public ResponseEntity<List<Equipe>> getEquipe() {
        List<Equipe> equipes = equipeService.getEquipes();
        return new ResponseEntity<> (equipes, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addEquipe(@RequestBody Equipe equipe) {
        equipeService.addEquipe(equipe);
        return new ResponseEntity<>(equipe,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEquipr(@PathVariable("id") Long id) {
        equipeService.deletequipe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/findByPays/{pay}")
    public ResponseEntity<List<Equipe>> findEquipeByPay(@PathVariable("pay") String name) {
        List<Equipe> equipes = equipeService.findEquipebypays(name);
        return new ResponseEntity<>(equipes,HttpStatus.OK);
    }
    @GetMapping("/getJoueurParEquipe/{nomEquipe}")
    public ResponseEntity<Collection<Joueur>> getJoueurParEquipe(@PathVariable("nomEquipe") String nomEquipe){
       Collection<Joueur> joueurs =  equipeService.getJoueurParEquipe(nomEquipe);
       return new ResponseEntity<>(joueurs,HttpStatus.OK);
    }

    @GetMapping("/equipe/{nomequipe}")
    public ResponseEntity<Equipe> getEquipeBynomEquipe(@PathVariable String nomequipe){
        Equipe equipe = equipeService.getEquipeBynomEquipe(nomequipe);
        if(equipe == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(equipe,HttpStatus.OK);
    }
}

