package com.akbulutmehmet.webservice.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CreateCategoryRequest implements Serializable {
    @NotBlank(message = "Title field should not be blank")
    @NotEmpty(message =  "Title field should not be emty")
    private String title;
    @NotBlank(message = "Description field should not be blank")
    @NotEmpty(message =  "Description field should not be emty")
    private String description;
    @NotBlank(message = "User id field should not be blank")
    @NotEmpty(message =  "User id field should not be emty")
    private String userId;

    public CreateCategoryRequest() {
    }

    public CreateCategoryRequest(String title, String description, String userId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public CreateCategoryRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
