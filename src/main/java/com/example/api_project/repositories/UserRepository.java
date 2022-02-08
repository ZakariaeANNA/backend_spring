package com.example.api_project.repositories;

import com.example.api_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
        User findByUsername(String Username);
        List<User> findByEmail(String Email);
}
