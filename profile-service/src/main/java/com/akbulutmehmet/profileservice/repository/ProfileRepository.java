package com.akbulutmehmet.profileservice.repository;

import com.akbulutmehmet.profileservice.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile,String> {
    Optional<Profile> findByUserId(String userId);
}
