package com.example.api_project.controller;

import com.example.api_project.entity.Equipe;
import com.example.api_project.entity.Matche;
import com.example.api_project.entity.Stade;
import com.example.api_project.repositories.MatcheRepository;
import com.example.api_project.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatcheController {

    @Autowired
    MatchService matchService;

    @Autowired
    MatcheRepository matcheRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Matche>> getAllMatches(){
        List<Matche> matches = matchService.getMatches();
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveMatche(@RequestBody Matche matche)
    {
        matchService.addMatche(matche);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMatcheById(@PathVariable Long id)
    {
        matchService.deleteMatche(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{date}")
    public ResponseEntity<List<Matche>> getMatchesBydate(@PathVariable String date) throws ParseException {

        List<Matche> matches = matchService.getMatchesBydate(date);
        return new ResponseEntity<>(matches,HttpStatus.OK);
    }

    @GetMapping("/findStateById/{id}")
    public ResponseEntity<Stade> getStadeByMatchId(@PathVariable Long id){
        Stade stade = matchService.getStadeByMatchId(id);
        return new ResponseEntity<>(stade,HttpStatus.OK);
    }

    @GetMapping("/findEquipesById/{id}")
    public ResponseEntity<List<Equipe>> getEquipesByMatchID(@PathVariable Long id){
        List<Equipe> equipes =  matchService.getEquipesByMatchID(id);
        return new ResponseEntity<>(equipes,HttpStatus.OK);
    }

    @DeleteMapping("/deletePasses")
    public ResponseEntity<?> supprimeMatchesPasse()  {
        matcheRepository.suppmatchpasse();
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
