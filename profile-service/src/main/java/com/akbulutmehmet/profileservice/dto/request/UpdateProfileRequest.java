package com.akbulutmehmet.profileservice.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class UpdateProfileRequest implements Serializable {
    @NotBlank(message = "Userid field should not be blank")
    @NotEmpty(message = "Userid field should not be empty")
    private String userId;
    @NotBlank(message = "Name field should not be blank")
    @NotEmpty(message = "Name field should not be empty")
    private String name;
    @NotBlank(message = "Surname field should not be blank")
    @NotEmpty(message = "Surname field should not be empty")
    private String surname;
    @NotBlank(message = "City field should not be blank")
    @NotEmpty(message = "City field should not be empty")
    private String city;
    @NotBlank(message = "Country field should not be blank")
    @NotEmpty(message = "Country field should not be empty")
    private String country;

    public UpdateProfileRequest() {
    }

    public UpdateProfileRequest(String userId, String name, String surname, String city, String country) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.country = country;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
