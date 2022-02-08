package com.example.api_project.service;


import com.example.api_project.entity.Matche;
import com.example.api_project.repositories.MatcheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
