package com.akbulutmehmet.profileservice.dto.response;

import java.io.Serializable;

public class ProfileDto implements Serializable {
    private String id;
    private String userId;
    private String name;
    private String surname;
    private String city;
    private String country;

    public ProfileDto() {
    }

    public ProfileDto(String id, String userId, String name, String surname, String city, String country) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
