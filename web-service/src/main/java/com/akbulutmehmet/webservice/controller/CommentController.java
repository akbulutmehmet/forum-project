package com.akbulutmehmet.webservice.controller;

import com.akbulutmehmet.webservice.dto.request.CreateCommentRequest;
import com.akbulutmehmet.webservice.dto.request.UpdateCommentRequest;
import com.akbulutmehmet.webservice.dto.response.CommentDto;
import com.akbulutmehmet.webservice.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/comment")
@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600)
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping(value = "/createComment")
    public ResponseEntity<CommentDto> createComment (@Valid @RequestBody CreateCommentRequest createCommentRequest){
        return ResponseEntity.ok(commentService.createComment(createCommentRequest));
    }
    @PostMapping(value = "/updateComment")
    public ResponseEntity<CommentDto> updateComment (@Valid @RequestBody UpdateCommentRequest updateCommentRequest){
        return ResponseEntity.ok(commentService.updateComment(updateCommentRequest));
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<CommentDto>>  getCommentsByPostId (@PathVariable("id") String postId) {
        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
    }
    @DeleteMapping(value = "deleteComment/{id}")
    public void deleteComment(@PathVariable("id") String id){
        commentService.deleteComment(id);
    }

}
