package com.akbulutmehmet.profileservice.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class TokenRequest implements Serializable {
    @NotBlank(message = "Token field  should not be blank ")
    @NotEmpty(message = "Token field  should not be empty")
    private String token;

    public TokenRequest() {
    }

    public TokenRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

