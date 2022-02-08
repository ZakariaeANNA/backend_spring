package com.example.api_project.controller;

import com.example.api_project.entity.Arbitre;
import com.example.api_project.service.ArbitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arbitres")
public class ArbitreController {

    @Autowired
    ArbitreService arbitreService;

    @GetMapping("/all")
    public List<Arbitre> getAllArbitres(){
        return arbitreService.getArbitre();
    }

    @PostMapping("/add")
    public void addArbitre(@RequestBody Arbitre arbitre){
        arbitreService.addAarbitre(arbitre);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArbitreById(@PathVariable Long id){
        arbitreService.deleteArbitre(id);
    }
}
