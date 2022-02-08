package com.example.api_project.repositories;

import com.example.api_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

        User findByUsername(String Username);
}
