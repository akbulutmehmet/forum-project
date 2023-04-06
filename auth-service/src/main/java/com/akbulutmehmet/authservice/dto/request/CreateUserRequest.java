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
    @Email
    private String email;
    @NotBlank(message = "Password field should not be blank")
    @NotEmpty(message = "Password field should not be empty")
    private String password;

    public CreateUserRequest(String name, String surName, String email, String password) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
    }

    public CreateUserRequest() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
