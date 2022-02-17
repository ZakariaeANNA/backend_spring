package com.example.api_project.controller;

import com.example.api_project.dto.Matchedto;
import com.example.api_project.entity.Arbitre;
import com.example.api_project.entity.Equipe;
import com.example.api_project.entity.Matche;
import com.example.api_project.entity.Stade;
import com.example.api_project.repositories.MatcheRepository;
import com.example.api_project.service.ArbitreService;
import com.example.api_project.service.MatchService;
import com.example.api_project.service.StadeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matches")
public class MatcheController {

    @Autowired
    MatchService matchService;

    @Autowired
    MatcheRepository matcheRepository;

    @Autowired
    StadeService stadeService;

    @Autowired
    ArbitreService arbitreService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/all")
    public ResponseEntity<List<Matchedto>> getAllMatches(){
        List<Matchedto> matches = matchService.getMatches().stream().map(matche -> modelMapper.map(matche,Matchedto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveMatche(@RequestBody Matche matche)
    {
        matchService.addMatche(matche);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updeateMatche(@RequestBody Matche matche)
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

    @GetMapping("/findStadeAndArbitre/{nomstade}/{nomarbitre}")
    public ResponseEntity<HashMap<String,Object>> getStadeAndArbitreByNom(@PathVariable("nomstade") String nomstade,@PathVariable("nomarbitre") String nomarbitre){
        HashMap<String,Object> map = new HashMap<>();
        Stade stade = stadeService.getStadeBynomStade(nomstade);
        Arbitre arbitre = arbitreService.getArbitreBynom(nomarbitre);
        if(arbitre!=null && stade!=null){
            map.put("stade",stade);
            map.put("arbitre",arbitre);
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
