package com.example.api_project.repositories;

import com.example.api_project.entity.Matche;
import com.example.api_project.entity.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StadeRepository extends JpaRepository<Stade,Long> {


    Stade findStadeBynomStade(String nomstade);

}
