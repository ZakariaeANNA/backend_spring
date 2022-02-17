package com.example.api_project.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Equipe  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEquipe;

    @Column(updatable = false)
    String nomEquipe;

    @Column(updatable = false)
    String pays;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinTable(name = "matches_equipes",
            joinColumns = @JoinColumn(name = "idEquipe"),
            inverseJoinColumns = @JoinColumn(name = "idMatch")
    )
    List<Matche> matches;

    @JsonManagedReference("equipe")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "equipe",cascade = CascadeType.ALL)
    Collection<Joueur> joueurs;
}
