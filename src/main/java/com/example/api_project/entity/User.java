package com.example.api_project.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 100)
    String username;

    String password;

    int active;

    String roles = "";

    public List<String> roles(){
        List<String> lib8iti = new ArrayList<String>();
        lib8iti = Arrays.asList(this.roles.split(","));
        return lib8iti;
    }

}
