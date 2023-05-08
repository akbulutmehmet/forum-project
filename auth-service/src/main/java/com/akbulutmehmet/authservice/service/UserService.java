package com.akbulutmehmet.authservice.service;

import com.akbulutmehmet.authservice.dto.converter.UserDtoConverter;
import com.akbulutmehmet.authservice.dto.request.CreateProfileRequest;
import com.akbulutmehmet.authservice.dto.request.CreateUserRequest;
import com.akbulutmehmet.authservice.dto.request.LoginRequest;
import com.akbulutmehmet.authservice.dto.request.TokenRequest;
import com.akbulutmehmet.authservice.dto.response.TokenDto;
import com.akbulutmehmet.authservice.dto.response.UserDto;
import com.akbulutmehmet.authservice.exception.UserException;
import com.akbulutmehmet.authservice.manager.IProfileManager;
import com.akbulutmehmet.authservice.model.Role;
import com.akbulutmehmet.authservice.model.User;
import com.akbulutmehmet.authservice.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = true,rollbackFor = UserException.class)
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final IProfileManager profileManager;
    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter, JwtService jwtService, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, IProfileManager profileManager) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.profileManager = profileManager;
    }

    @Transactional(readOnly = false)
    public TokenDto userRegister(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setName(createUserRequest.getName());
        user.setSurName(createUserRequest.getSurName());
        user.setUsername(createUserRequest.getUsername());
        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        user.setRole(Role.USER);
        User newUser = userRepository.save(user);
        profileManager.createProfile(new CreateProfileRequest(newUser.getId(), newUser.getName(), newUser.getSurName()));
        return new TokenDto(jwtService.generateToken(newUser),newUser.getId());
    }

    public TokenDto userLogin(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),loginRequest.getPassword()));
        User user = userRepository.
                findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return new TokenDto(jwtService.generateToken(user),user.getId());
    }
    public List<UserDto> listUser () {
        return userRepository.findAll().stream().map((user) -> userDtoConverter.convert(user)).collect(Collectors.toList());
    }

    public Boolean tokenControl(TokenRequest tokenRequest) {
        String username = null;
        try{
            username = jwtService.findUsername(tokenRequest.getToken());
            User user = userRepository.
                    findByUsername(username).
                    orElseThrow(() -> new UsernameNotFoundException("Username not found"));
            return jwtService.tokenControl(tokenRequest.getToken(),user);
        }catch (Exception exception){
            exception.getMessage();
        }
        return false;
    }
}
