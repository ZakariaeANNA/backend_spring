package com.example.api_project.repositories;

import com.example.api_project.entity.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadeRepository extends JpaRepository<Stade,Long> {

}
