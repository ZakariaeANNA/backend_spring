package com.example.api_project.service;


import com.example.api_project.entity.Equipe;
import com.example.api_project.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {
    @Autowired
    EquipeRepository equipeRepository;


    public List<Equipe> getEquipes()
    {
        return equipeRepository.findAll();
    }
    public void addEquipe(Equipe equipe)
    {
        equipeRepository.save(equipe);
    }

    public void deletequipe(Long id)
    {
        equipeRepository.deleteById(id);
    }
}
