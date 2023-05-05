package com.akbulutmehmet.profileservice.dto.converter;

import com.akbulutmehmet.profileservice.dto.request.CreateProfileRequest;
import com.akbulutmehmet.profileservice.dto.response.ProfileDto;
import com.akbulutmehmet.profileservice.model.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileDtoConverter {
    public ProfileDto convert (Profile profile) {
        return new ProfileDto(profile.getId(), profile.getUserId(), profile.getName(), profile.getSurname(), profile.getCity(), profile.getCountry());
    }
    public Profile convert(CreateProfileRequest createProfileRequest) {
        Profile profile = new Profile();
        profile.setUserId(createProfileRequest.getUserId());
        profile.setName(createProfileRequest.getName());
        profile.setSurname(createProfileRequest.getSurname());
        return profile;
    }
}
