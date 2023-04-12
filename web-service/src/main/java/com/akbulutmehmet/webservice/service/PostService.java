package com.akbulutmehmet.webservice.service;


import com.akbulutmehmet.webservice.dto.converter.PostDtoConverter;
import com.akbulutmehmet.webservice.dto.request.CreatePostRequest;
import com.akbulutmehmet.webservice.dto.response.PostDto;
import com.akbulutmehmet.webservice.model.Category;
import com.akbulutmehmet.webservice.model.Post;
import com.akbulutmehmet.webservice.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final CategoryService categoryService;
    private final PostDtoConverter postDtoConverter;

    public PostService(PostRepository postRepository, CategoryService categoryService, PostDtoConverter postDtoConverter) {
        this.postRepository = postRepository;
        this.categoryService = categoryService;
        this.postDtoConverter = postDtoConverter;
    }
    @Transactional(readOnly = false)
    public PostDto createPost(CreatePostRequest createPostRequest) {
        Category category = categoryService.findById(createPostRequest.getCategoryId());
        Post post = new Post();
        post.setCategory(category);
        post.setContent(createPostRequest.getContent());
        return postDtoConverter.convert(postRepository.save(post));
    }
}
