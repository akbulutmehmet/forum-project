package com.akbulutmehmet.authservice.service;

import com.akbulutmehmet.authservice.dto.converter.UserDtoConverter;
import com.akbulutmehmet.authservice.dto.request.CreateUserRequest;
import com.akbulutmehmet.authservice.dto.request.LoginRequest;
import com.akbulutmehmet.authservice.dto.response.UserDto;
import com.akbulutmehmet.authservice.exception.UserException;
import com.akbulutmehmet.authservice.manager.IProfileManager;
import com.akbulutmehmet.authservice.model.Role;
import com.akbulutmehmet.authservice.model.User;
import com.akbulutmehmet.authservice.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = true,rollbackFor = UserException.class)
public class UserService {
    private final UserRepository userRepository;
    private final IProfileManager profileManager;
    private final UserDtoConverter userDtoConverter;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public UserService(UserRepository userRepository,
                       IProfileManager profileManager,
                       UserDtoConverter userDtoConverter,
                       RoleService roleService
    ) {
        this.userRepository = userRepository;
        this.profileManager = profileManager;
        this.userDtoConverter = userDtoConverter;
        this.roleService = roleService;
    }


    @Transactional(readOnly = false)
    public UserDto userRegister(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setName(createUserRequest.getName());
        user.setSurName(createUserRequest.getSurName());
        user.setUsername(createUserRequest.getUsername());
        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findByRoleName("ROLE_USER"));
        user.setRoles(roles);
        return userDtoConverter.convert(userRepository.save(user));
    }

    public String userLoginWithEmailAndPassword(LoginRequest loginRequest) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword()).
                orElseThrow(() -> new UserException("User not found!")));
        if (user != null) {
            return "ok";
        }
        return "fail";
    }

    public User loadUserByUsername (String username) {
        return userRepository.findByUsername(username);
    }

    public List<UserDto> listUsers() {
      return  userRepository.findAll().stream().map(user -> userDtoConverter.convert(user)).collect(Collectors.toList());
    }
}
