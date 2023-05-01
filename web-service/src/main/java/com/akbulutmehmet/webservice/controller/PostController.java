package com.akbulutmehmet.webservice.controller;

import com.akbulutmehmet.webservice.dto.request.CreatePostRequest;
import com.akbulutmehmet.webservice.dto.response.PostDto;
import com.akbulutmehmet.webservice.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/post")
@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600)
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
