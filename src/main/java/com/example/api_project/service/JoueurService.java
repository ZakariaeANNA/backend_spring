package com.example.api_project.service;


import com.example.api_project.entity.Equipe;
import com.example.api_project.entity.Joueur;
import com.example.api_project.repositories.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoueurService {

    @Autowired
    JoueurRepository joueurRepository;

    public List<Joueur> getJoueurs()
    {
        return joueurRepository.findAll();
    }

    public void addJoueur(Joueur joueur)
    {
        joueurRepository.save(joueur);
    }

    public void deleteJoueur(Long id)
    {
        joueurRepository.deleteById(id);
    }

    public List<Joueur> JoueurParposteEquipe(String poste,String nomequipe){
        return joueurRepository.findJoueurByPosteAndEquipe(poste,nomequipe);
    }
}
