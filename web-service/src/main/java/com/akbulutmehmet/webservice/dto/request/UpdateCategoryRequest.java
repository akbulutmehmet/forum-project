package com.akbulutmehmet.webservice.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class UpdateCategoryRequest implements Serializable {
    @NotBlank(message = "Id field should not be blank")
    @NotEmpty(message =  "Id field should not be emty")
    private String id;
    @NotBlank(message = "Title field should not be blank")
    @NotEmpty(message =  "Title field should not be emty")
    private String title;
    @NotBlank(message = "Description field should not be blank")
    @NotEmpty(message =  "Description field should not be emty")
    private String description;

    public UpdateCategoryRequest() {
    }

    public UpdateCategoryRequest(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
