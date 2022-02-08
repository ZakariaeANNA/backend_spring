package com.example.api_project.service;


import com.example.api_project.entity.Equipe;
import com.example.api_project.entity.Matche;
import com.example.api_project.entity.Stade;
import com.example.api_project.repositories.MatcheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MatchService {
    @Autowired
    MatcheRepository matcheRepository;


    public List<Matche> getMatches()
    {
        return matcheRepository.findAll();
    }
    public void addMatche(Matche matche)
    {
        matcheRepository.save(matche);
    }
    public void deleteMatche(Long id)
    {
        matcheRepository.deleteById(id);
    }
    public List<Matche> getMatchesBydate(String date) throws ParseException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date datematch = simpleDateFormat.parse(date);
        return matcheRepository.findMatchesBydate(datematch);
    }
    public Stade getStadeByMatchId(Long id){
        return matcheRepository.findStadeByMatchID(id);
    }
    public List<Equipe> getEquipesByMatchID(Long id){
        return matcheRepository.findEquipesByMatchID(id);
    }
    public void supprimeMatchesPasse()  {
        matcheRepository.suppmatchpasse();
    }

}
