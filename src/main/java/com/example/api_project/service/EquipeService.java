package com.example.api_project.service;


import com.example.api_project.entity.Equipe;
import com.example.api_project.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public List<Equipe> deleteEquipebypays(String pays){
        List<Equipe> equipes = equipeRepository.findAll();
        equipes.forEach((equipe -> {
            if(!(equipe.getPays().equals(pays)))
                System.out.println(equipe.getNomEquipe());
        }));
        return equipes;
    }
}
