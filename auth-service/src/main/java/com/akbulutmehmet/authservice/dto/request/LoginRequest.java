package com.akbulutmehmet.authservice.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginRequest {
    @NotBlank(message = "Email field should not be blank")
    @NotEmpty(message = "Email field should not be empty")
    @Size(min = 6,message = "it must be min 6 character")
    private String username;
    @NotBlank(message = "Password field should not be blank")
    @NotEmpty(message = "Password field should not be empty")
    @Size(min = 6,message = "it must be min 6 character")
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
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
