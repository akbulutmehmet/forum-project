package com.akbulutmehmet.authservice.dto.request;

import java.io.Serializable;

public class UserRequestDto implements Serializable {

    private String id;
    private String name;
    private String surName;
    private String email;
    private String password;

    public UserRequestDto(String id, String name, String surName, String email, String password) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
    }

    public UserRequestDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
