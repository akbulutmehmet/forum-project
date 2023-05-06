package com.akbulutmehmet.authservice.dto.request;

import java.io.Serializable;

public class CreateProfileRequest implements Serializable {

    private String userId;
    private String name;
    private String surname;

    public CreateProfileRequest() {
    }

    public CreateProfileRequest(String userId, String name, String surname) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
