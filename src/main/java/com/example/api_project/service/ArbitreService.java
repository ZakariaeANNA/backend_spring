package com.example.api_project.service;


import com.example.api_project.entity.Arbitre;
import com.example.api_project.repositories.ArbitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArbitreService {

    @Autowired
    ArbitreRepository arbitreRepository;
    public List<Arbitre> getArbitre(){
        return arbitreRepository.findAll();
    }
    public void addAarbitre(Arbitre arbitre)
    {
        arbitreRepository.save(arbitre);
    }
    public void deleteArbitre(Long id)
    {
        arbitreRepository.deleteById(id);
    }

    public Arbitre getArbitreBynom(String nom){
        return arbitreRepository.findArbitreBynom(nom);
    }
}
