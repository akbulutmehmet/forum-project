package com.akbulutmehmet.profileservice.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CreateProfileRequest implements Serializable {
    @NotBlank(message = "Userid field should not be blank")
    @NotEmpty(message = "Userid field should not be empty")
    private String userId;
    @NotBlank(message = "Name field should not be blank")
    @NotEmpty(message = "Name field should not be empty")
    private String name;
    @NotBlank(message = "Surname field should not be blank")
    @NotEmpty(message = "Surname field should not be empty")
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
