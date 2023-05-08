package com.akbulutmehmet.authservice.dto.response;

import java.io.Serializable;

public class TokenDto implements Serializable {
    private String token;
    private String userId;


    public TokenDto() {
    }

    public TokenDto(String token, String userId) {
        this.token = token;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public TokenDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
