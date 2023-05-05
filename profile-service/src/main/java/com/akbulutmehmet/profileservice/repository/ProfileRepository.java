package com.akbulutmehmet.profileservice.repository;

import com.akbulutmehmet.profileservice.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,String> {
    Profile findByUserId(String userId);
}
