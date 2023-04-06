package com.akbulutmehmet.authservice.service;

import com.akbulutmehmet.authservice.dto.request.CreateUserRequest;
import com.akbulutmehmet.authservice.dto.request.LoginRequest;
import com.akbulutmehmet.authservice.dto.response.UserDto;
import com.akbulutmehmet.authservice.exception.UserException;
import com.akbulutmehmet.authservice.mapper.IUserMapper;
import com.akbulutmehmet.authservice.model.User;
import com.akbulutmehmet.authservice.repository.UserRepository;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    private final IUserMapper userMapper;

    public UserService(UserRepository userRepository, IUserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = false)
    public UserDto userRegister(CreateUserRequest createUserRequest) {
        User user = userMapper.toUser(createUserRequest);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public String userLoginWithEmailAndPassword(LoginRequest loginRequest) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword()).
                orElseThrow(() -> new UserException("User not found!")));
        if (user != null) {
            return "ok";
        }
        return "fail";
    }
}
