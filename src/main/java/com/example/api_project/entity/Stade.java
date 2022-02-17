package com.example.api_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Stade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idStade;

    @Column
    String nomStade;

    @Column
    String villeStade;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "stade")
    @JsonManagedReference("stade")
    Collection<Matche> matches;
}
