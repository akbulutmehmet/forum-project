package com.akbulutmehmet.authservice.controller;

import com.akbulutmehmet.authservice.dto.request.CreateUserRequest;
import com.akbulutmehmet.authservice.dto.response.UserDto;
import com.akbulutmehmet.authservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "userRegister")
    public ResponseEntity<UserDto> userRegister(@Valid @RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(userService.userRegister(createUserRequest));
    }

}
