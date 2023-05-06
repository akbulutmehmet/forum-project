package com.akbulutmehmet.profileservice.controller;

import com.akbulutmehmet.profileservice.dto.request.CreateProfileRequest;
import com.akbulutmehmet.profileservice.dto.request.UpdateProfileRequest;
import com.akbulutmehmet.profileservice.dto.response.ProfileDto;
import com.akbulutmehmet.profileservice.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/profile")
@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600)
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<ProfileDto> getByUserId (@PathVariable("userId") String userId) {
        return ResponseEntity.ok(profileService.getByUserId(userId));
    }
    @PostMapping("/updateProfile/${userId}")
    public ResponseEntity<ProfileDto> updateProfileByUserId (@PathVariable("userId") String userId,@Valid @RequestBody UpdateProfileRequest updateProfileRequest){
        return ResponseEntity.ok(profileService.updateProfile(userId,updateProfileRequest));
    }

    @PostMapping(value = "/createProfile")
    public ResponseEntity<ProfileDto> createProfile (@Valid @RequestBody CreateProfileRequest createProfileRequest){
        return ResponseEntity.ok(profileService.createProfile(createProfileRequest));
    }
}
