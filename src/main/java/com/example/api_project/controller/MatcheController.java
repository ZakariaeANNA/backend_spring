package com.example.api_project.controller;

import com.example.api_project.entity.Equipe;
import com.example.api_project.entity.Matche;
import com.example.api_project.entity.Stade;
import com.example.api_project.repositories.MatcheRepository;
import com.example.api_project.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Matche> getAllMatches(){
        return matchService.getMatches();
    }

    @PostMapping("/add")
    public void addMatche(@RequestBody Matche matche){
        matchService.addMatche(matche);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMatcheById(@PathVariable Long id){
        matchService.deleteMatche(id);
    }

    @GetMapping("/find/{date}")
    public List<Matche> getMatchesBydate(@PathVariable String date) throws ParseException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date datematch = simpleDateFormat.parse(date);
        return matcheRepository.findMatchesBydate(datematch);
    }

    @GetMapping("/findStateById/{id}")
    public Stade getStadeByMatchId(@PathVariable Long id){
        return matcheRepository.findStadeByMatchID(id);
    }

    @GetMapping("/findEquipesById/{id}")
    public List<Equipe> getEquipesByMatchID(@PathVariable Long id){
        return matcheRepository.findEquipesByMatchID(id);
    }

    @DeleteMapping("/deletePasses")
    public void supprimeMatchesPasse()  {
        matcheRepository.suppmatchpasse();
    }


}
