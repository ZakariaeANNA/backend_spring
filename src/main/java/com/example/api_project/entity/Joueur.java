package com.example.api_project.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Joueur  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idJoueur;

    @Column
    String nomJoueur;

    @Column
    String poste;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name="id_Equipe")
    @JsonBackReference("equipe")

    Equipe equipe;
}
