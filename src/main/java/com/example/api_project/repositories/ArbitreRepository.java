package com.example.api_project.repositories;

import com.example.api_project.entity.Arbitre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbitreRepository extends JpaRepository<Arbitre,Long> {

    Arbitre findArbitreBynom(String nom);
}
