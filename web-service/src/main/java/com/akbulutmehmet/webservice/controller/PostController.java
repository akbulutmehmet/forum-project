package com.akbulutmehmet.webservice.controller;

import com.akbulutmehmet.webservice.dto.request.CreatePostRequest;
import com.akbulutmehmet.webservice.dto.response.PostDto;
import com.akbulutmehmet.webservice.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping(value = "/createPost")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody CreatePostRequest createPostRequest){
        return ResponseEntity.ok(postService.createPost(createPostRequest));
    }
}
