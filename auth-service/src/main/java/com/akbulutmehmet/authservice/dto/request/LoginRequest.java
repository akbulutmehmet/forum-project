package com.akbulutmehmet.authservice.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class LoginRequest {
    @NotBlank(message = "Email field should not be blank")
    @NotEmpty(message = "Email field should not be empty")
    @Email
    private String email;
    @NotBlank(message = "Password field should not be blank")
    @NotEmpty(message = "Password field should not be empty")
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginRequest() {
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
