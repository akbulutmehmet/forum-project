package com.akbulutmehmet.webservice.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CreatePostRequest implements Serializable {
    @NotBlank(message = "Content field should not be blank")
    @NotEmpty(message =  "Content field should not be emty")
    private String content;

    @NotBlank(message = "Title field should not be blank")
    @NotEmpty(message =  "Title field should not be emty")
    private String title;
    @NotBlank(message = "categoryId field should not be blank")
    @NotEmpty(message =  "categoryId field should not be emty")
    private String categoryId;
    @NotBlank(message = "userId field should not be blank")
    @NotEmpty(message =  "userId field should not be emty")
    private String userId;
    public CreatePostRequest() {
    }

    public CreatePostRequest(String content, String title, String categoryId, String userId) {
        this.content = content;
        this.title = title;
        this.categoryId = categoryId;
        this.userId = userId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
