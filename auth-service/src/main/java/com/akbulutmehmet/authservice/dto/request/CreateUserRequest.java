package com.akbulutmehmet.authservice.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CreateUserRequest implements Serializable {
    @NotBlank(message = "Name field should not be blank")
    @NotEmpty(message = "Name field should not be empty")
    private String name;
    @NotBlank(message = "Surname field should not be blank")
    @NotEmpty(message = "Surname field should not be empty")
    private String surName;
    @NotBlank(message = "Email field should not be blank")
    @NotEmpty(message = "Email field should not be empty")
    private String username;
    @NotBlank(message = "Password field should not be blank")
    @NotEmpty(message = "Password field should not be empty")
    private String password;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String name, String surName, String username, String password) {
        this.name = name;
        this.surName = surName;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
