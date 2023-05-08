package com.akbulutmehmet.webservice.dto.response;

import java.io.Serializable;

public class CommentDto implements Serializable {
    private String id;
    private String content;
    private String userId;
    public CommentDto() {
    }

    public CommentDto(String id, String content, String userId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
