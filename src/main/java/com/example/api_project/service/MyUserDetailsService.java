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

    public User registerNewUserAccount(User user) {
        user.setRoles("ROLE_USERNAME");
        user.setActive(1);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }
    public boolean userExist(String username) {
        return userRepository.findByUsername(username) != null;
    }

}
