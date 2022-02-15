package com.example.api_project.repositories;

import com.example.api_project.entity.Equipe;
import com.example.api_project.entity.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur,Long> {


    @Query("SELECT j from Joueur j WHERE j.poste=?1 and j.equipe.nomEquipe=?2")
    List<Joueur> findJoueurByPosteAndEquipe(String poste, String nomequipe);

}
