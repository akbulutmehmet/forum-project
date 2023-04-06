package com.akbulutmehmet.authservice.dto.response;

import java.io.Serializable;

public class UserDto implements Serializable {
    private String id;
    private String name;
    private String surName;
    private String email;
    private String password;

    public UserDto(String id, String name, String surName, String email, String password) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
    }

    public UserDto() {
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
