package com.example.api_project.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Arbitre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idArbitre;

    @Column
    String nom;

    @Column
    String Nationalite;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "arbitre")
    @JsonManagedReference("arbitre")
    Collection<Matche> Matches;
}
