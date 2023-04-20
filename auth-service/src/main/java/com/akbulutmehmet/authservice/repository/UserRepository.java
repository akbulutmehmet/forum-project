package com.akbulutmehmet.authservice.repository;

import com.akbulutmehmet.authservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByUsernameAndPassword(String username,String password);
    Optional<User> findByUsername(String username);
}