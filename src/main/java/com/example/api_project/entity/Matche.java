package com.example.api_project.entity;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idMatch")
public class Matche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idMatch;

    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date dateMatch;

    @Column
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "hh:mm")
    Date heureMatch;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE )
    @JoinColumn(name="idArbitre")
    @JsonBackReference("arbitre")
    Arbitre arbitre;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="idStade")
    @JsonBackReference("stade")
    Stade stade;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(
            name = "matches_equipes",
            joinColumns = @JoinColumn(name = "idMatch", referencedColumnName = "idMatch"),
            inverseJoinColumns = @JoinColumn(name = "idEquipe" , referencedColumnName = "idEquipe")
    )
    Collection<Equipe> equipes;

}
