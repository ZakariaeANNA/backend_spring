package com.example.api_project.controller;

<<<<<<< HEAD

import com.example.api_project.entity.User;
import com.example.api_project.repositories.UserRepository;
import com.example.api_project.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MyUserDetailsService myUserDetailsService;


    @PostMapping("/user/save")
    public User saveUser(@RequestBody User user) throws Exception {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return myUserDetailsService.registerNewUserAccount(user);
    }

    @GetMapping("/home")
    public String home(){
        return "Bonjour";
    }
=======
public class UserController {
>>>>>>> 93efa19c77cf290f1d87cb164a1bb00fdaba77bc
}
