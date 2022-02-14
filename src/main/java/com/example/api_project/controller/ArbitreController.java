package com.example.api_project.controller;

import com.example.api_project.entity.Arbitre;
import com.example.api_project.service.ArbitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arbitres")
public class ArbitreController {

    @Autowired
    ArbitreService arbitreService;

    @GetMapping("/all")
    public ResponseEntity<List<Arbitre>> getAllArbitres() {
        List<Arbitre> arbitres = arbitreService.getArbitre();
        return new ResponseEntity<>(arbitres, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addArbitre(@RequestBody Arbitre arbitre) {
        arbitreService.addAarbitre(arbitre);
        System.out.println(arbitre.toString()+"jjjjjj");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteArbitre(@PathVariable Long id) {
        arbitreService.deleteArbitre(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/arbitre/{nom}")
    public ResponseEntity<Arbitre> getArbitreBynom(@PathVariable String nom){
        Arbitre arbitre = arbitreService.getArbitreBynom(nom);
        if(arbitre == null ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(arbitre,HttpStatus.OK);
    }
}
