package com.akbulutmehmet.webservice.dto.response;


import java.io.Serializable;
import java.util.Set;

public class PostDto implements Serializable {
    private String id;
    private String content;
    private Set<CommentDto> comments;

    public PostDto() {
    }

    public PostDto(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public PostDto(String id, String content, Set<CommentDto> comments) {
        this.id = id;
        this.content = content;
        this.comments = comments;
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
