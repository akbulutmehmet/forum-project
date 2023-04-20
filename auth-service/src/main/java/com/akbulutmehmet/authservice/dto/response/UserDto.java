package com.akbulutmehmet.authservice.dto.response;

import java.io.Serializable;
import java.util.List;

public class UserDto implements Serializable {
    private String id;
    private String name;
    private String surName;
    private String username;


    public UserDto() {
    }

    public UserDto(String id, String name, String surName, String username) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.username = username;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
