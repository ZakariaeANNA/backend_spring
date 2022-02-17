package com.example.api_project.repositories;

import com.example.api_project.entity.Equipe;
import com.example.api_project.entity.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe,Long> {

    @Query("SELECT e from Equipe e WHERE e.pays=?1")
    List<Equipe> findEquipesBypays(String pays);

    @Query("SELECT e.joueurs from Equipe e where e.nomEquipe=?1")
    List<Joueur> getJoueursParEquipe(String nomequipe);

    Equipe findEquipeBynomEquipe(String nomequipe);

    Equipe findEquipeByidEquipe(Long id);

}
