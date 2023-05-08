package com.akbulutmehmet.webservice.dto.response;


import java.io.Serializable;
import java.util.Set;

public class PostDto implements Serializable {
    private String id;
    private String title;
    private String content;
    private String userId;
    private Set<CommentDto> comments;


    public PostDto() {
    }

    public PostDto(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public PostDto(String id, String title, String content, String userId, Set<CommentDto> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.comments = comments;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<CommentDto> getComments() {
        return comments;
    }

    public void setComments(Set<CommentDto> comments) {
        this.comments = comments;
    }
}
