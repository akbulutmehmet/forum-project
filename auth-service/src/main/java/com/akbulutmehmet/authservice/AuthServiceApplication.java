package com.akbulutmehmet.authservice;

import com.akbulutmehmet.authservice.model.Role;
import com.akbulutmehmet.authservice.model.User;
import com.akbulutmehmet.authservice.service.RoleService;
import com.akbulutmehmet.authservice.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AuthServiceApplication implements ApplicationRunner {
    private final UserService userService;

    private final RoleService roleService;

    public AuthServiceApplication(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role roleUser = new Role(1L,"ROLE_USER");
        Role roleAdmin = new Role(2L,"ROLE_ADMIN");
        roleService.saveRoles(List.of(roleUser,roleAdmin));

    }
}