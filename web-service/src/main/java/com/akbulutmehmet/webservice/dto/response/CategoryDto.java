package com.akbulutmehmet.webservice.dto.response;

import com.akbulutmehmet.webservice.model.Post;

import java.io.Serializable;
import java.util.Set;

public class CategoryDto implements Serializable {
    private String id;
    private String title;
    private String description;
    private String userId;
    private Set<PostDto> posts;

    public CategoryDto() {
    }

    public CategoryDto(String id, String title, String description, String userId, Set<PostDto> posts) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.posts = posts;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Set<PostDto> getPosts() {
        return posts;
    }

    public void setPosts(Set<PostDto> posts) {
        this.posts = posts;
    }
}
