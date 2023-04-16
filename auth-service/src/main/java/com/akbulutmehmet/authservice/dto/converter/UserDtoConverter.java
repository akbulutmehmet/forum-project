package com.akbulutmehmet.authservice.dto.converter;

import com.akbulutmehmet.authservice.dto.response.UserDto;
import com.akbulutmehmet.authservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserDto convert(User user) {
        return new UserDto(user.getId(), user.getName(), user.getSurName(), user.getUsername(),user.getRoles());
    }
}
