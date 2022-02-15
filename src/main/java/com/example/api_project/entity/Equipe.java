package com.example.api_project.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idEquipe")
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEquipe;

    @Column
    String nomEquipe;

    @Column
    String pays;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinTable(name = "matches_equipes",
            joinColumns = @JoinColumn(name = "idEquipe"),
            inverseJoinColumns = @JoinColumn(name = "idMatch")
    )
    List<Matche> matches;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy="equipe", cascade = CascadeType.ALL)
    @JsonManagedReference("equipe")
    Collection<Joueur> joueurs;
}
