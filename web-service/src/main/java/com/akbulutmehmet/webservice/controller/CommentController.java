package com.akbulutmehmet.webservice.controller;

import com.akbulutmehmet.webservice.dto.request.CreateCommentRequest;
import com.akbulutmehmet.webservice.dto.response.CommentDto;
import com.akbulutmehmet.webservice.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping(value = "/createComment")
    public ResponseEntity<CommentDto> createComment (@Valid @RequestBody CreateCommentRequest createCommentRequest){
        return ResponseEntity.ok(commentService.createComment(createCommentRequest));
    }

}
