package com.akbulutmehmet.webservice.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CreateCommentRequest implements Serializable {
    @NotBlank(message = "Content field should not be blank")
    @NotEmpty(message =  "Content field should not be emty")
    private String content;
    @NotBlank(message = "postId field should not be blank")
    @NotEmpty(message =  "postId field should not be emty")
    private String postId;

    @NotBlank(message = "userId field should not be blank")
    @NotEmpty(message = "userId field should not be blank")
    private String userId;
    public CreateCommentRequest() {
    }

    public CreateCommentRequest(String content, String postId, String userId) {
        this.content = content;
        this.postId = postId;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
