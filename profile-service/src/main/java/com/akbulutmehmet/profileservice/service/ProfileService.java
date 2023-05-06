package com.akbulutmehmet.profileservice.service;

import com.akbulutmehmet.profileservice.dto.converter.ProfileDtoConverter;
import com.akbulutmehmet.profileservice.dto.request.CreateProfileRequest;
import com.akbulutmehmet.profileservice.dto.request.UpdateProfileRequest;
import com.akbulutmehmet.profileservice.dto.response.ProfileDto;
import com.akbulutmehmet.profileservice.exception.ProfileException;
import com.akbulutmehmet.profileservice.model.Profile;
import com.akbulutmehmet.profileservice.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = true,rollbackFor = ProfileException.class)
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileDtoConverter converter;

    public ProfileService(ProfileRepository profileRepository, ProfileDtoConverter converter) {
        this.profileRepository = profileRepository;
        this.converter = converter;
    }

    public ProfileDto getByUserId(String userId) {
        return converter.convert(findByUserId(userId));
    }
    public Profile findByUserId (String userId) {
        return profileRepository.findByUserId(userId).orElseThrow(() -> new ProfileException("Profile not found"));
    }

    @Transactional(readOnly = false)
    public ProfileDto createProfile(CreateProfileRequest createProfileRequest) {
        Profile profile = converter.convert(createProfileRequest);
        return converter.convert(profileRepository.save(profile));
    }

    @Transactional(readOnly = false)
    public ProfileDto updateProfile(String userId,UpdateProfileRequest updateProfileRequest) {
        Profile profile = findByUserId(userId);
        profile.setName(updateProfileRequest.getName());
        profile.setSurname(updateProfileRequest.getSurname());
        profile.setCity(updateProfileRequest.getCity());
        profile.setCountry(updateProfileRequest.getCountry());

        return converter.convert(profileRepository.save(profile));
    }
}
