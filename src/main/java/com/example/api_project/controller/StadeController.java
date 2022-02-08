
package com.example.api_project.controller;

import com.example.api_project.entity.Stade;
import com.example.api_project.service.StadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stades")
public class StadeController {

    @Autowired
    StadeService stadeService;

    @GetMapping("/all")
    public ResponseEntity<List<Stade>> getStades()
    {
        List<Stade> stades = stadeService.getStades();
        return new ResponseEntity<>(stades, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<List<Stade>> addStade(@RequestBody Stade stade)
    {
        stadeService.addStade(stade);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStade(@PathVariable("id") Long id)
    {
        stadeService.deleteStade(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
