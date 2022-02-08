package com.example.api_project.service;

import com.example.api_project.entity.User;
import com.example.api_project.repositories.UserRepository;
import com.example.api_project.security.MyUserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for "+ username + ".");
        }
        return new MyUserPrincipal(user);
    }

    public User registerNewUserAccount(User userRegistred) throws Exception {
        User userfoundedbyusername = userRepository.findByUsername(userRegistred.getUsername());
        if (userfoundedbyusername != null || userRepository.findByEmail(userRegistred.getEmail()).size() != 0) {
            throw new Exception("User found for "+ userRegistred.getUsername() + ".");
        }
        userRepository.save(userRegistred);
        return userRegistred;
    }

}
