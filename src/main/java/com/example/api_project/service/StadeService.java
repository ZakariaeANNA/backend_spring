package com.example.api_project.service;


import com.example.api_project.entity.Stade;
import com.example.api_project.repositories.StadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadeService {
    @Autowired
    StadeRepository stadeRepository;

    public List<Stade> getStades()
    {
      return stadeRepository.findAll();
    }
    public void addStade(Stade stade)
    {
        stadeRepository.save(stade);
    }
    public  void deleteStade(Long id)
    {
        stadeRepository.deleteById(id);
    }
    public Stade getStadeBynomStade(String nomstade){
        return stadeRepository.findStadeBynomStade(nomstade);
    }
}
