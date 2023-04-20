package com.akbulutmehmet.authservice.controller;

import com.akbulutmehmet.authservice.dto.request.CreateUserRequest;
import com.akbulutmehmet.authservice.dto.request.LoginRequest;
import com.akbulutmehmet.authservice.dto.request.TokenRequest;
import com.akbulutmehmet.authservice.dto.response.TokenDto;
import com.akbulutmehmet.authservice.dto.response.UserDto;
import com.akbulutmehmet.authservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<TokenDto> userRegister(@Valid @RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(userService.userRegister(createUserRequest));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<TokenDto> userLogin(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.userLogin(loginRequest));
    }

    @GetMapping(value = "listuser")
    public ResponseEntity<List<UserDto>> listUsers () {
        return ResponseEntity.ok(userService.listUser());
    }

    @PostMapping(value = "/tokenControl")
    public ResponseEntity<Boolean> tokenControl (@Valid @RequestBody TokenRequest tokenRequest) {
        return ResponseEntity.ok(userService.tokenControl(tokenRequest));
    }
}
