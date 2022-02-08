package com.example.api_project.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 100)
    String username;

    @Column(length = 100)
    String password;

    @Column(length = 100)
    public String firstName;

    @Column(length = 100)
    public String lastName;

    @Column(length = 100)
    public String email;

    private Boolean active;

    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date birthDate;

    String roles = "";

    public List<String> roles(){
        List<String> roles = new ArrayList<String>();
        roles = Arrays.asList(this.roles.split(","));
        return roles;
    }

}
