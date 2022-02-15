package com.example.api_project.repositories;

import com.example.api_project.entity.Equipe;
import com.example.api_project.entity.Matche;
import com.example.api_project.entity.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface MatcheRepository extends JpaRepository<Matche,Long> {

    @Query("SELECT m from Matche m where m.stade.nomStade=?1")
    List<Matche> MatcheInStade(String nomStade);

    @Query("SELECT m from Matche m where m.dateMatch=?1")
    List<Matche> findMatchesBydate(Date datematche);

    @Query("SELECT m.stade from Matche m where m.idMatch=?1")
    Stade findStadeByMatchID(Long id);

    @Query("SELECT m.equipes from Matche m WHERE m.idMatch=?1")
    List<Equipe> findEquipesByMatchID(Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Matche m WHERE m.dateMatch<CURRENT_DATE OR m.heureMatch<CURRENT_TIME ")
    void suppmatchpasse();
}
