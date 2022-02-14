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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idEquipe")
public class Equipe  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEquipe;

    @Column
    String nomEquipe;

    @Column
    String pays;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "matches_equipes",
            joinColumns = @JoinColumn(name = "idEquipe"),
            inverseJoinColumns = @JoinColumn(name = "idMatch")
    )
    List<Matche> matches;

    @JsonBackReference
    @JsonManagedReference("equipe")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "equipe",cascade = CascadeType.ALL)
    Collection<Joueur> joueurs;
}
