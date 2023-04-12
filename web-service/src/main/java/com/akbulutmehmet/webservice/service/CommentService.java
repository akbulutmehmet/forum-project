package com.akbulutmehmet.webservice.service;

import com.akbulutmehmet.webservice.dto.converter.CommentDtoConverter;
import com.akbulutmehmet.webservice.dto.request.CreateCommentRequest;
import com.akbulutmehmet.webservice.dto.response.CommentDto;
import com.akbulutmehmet.webservice.model.Comment;
import com.akbulutmehmet.webservice.model.Post;
import com.akbulutmehmet.webservice.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;
    private final CommentDtoConverter commentDtoConverter;

    public CommentService(CommentRepository commentRepository, PostService postService, CommentDtoConverter commentDtoConverter) {
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.commentDtoConverter = commentDtoConverter;
    }
    @Transactional(readOnly = false)
    public CommentDto createComment(CreateCommentRequest createCommentRequest) {
        Post post = postService.findById(createCommentRequest.getPostId());
        Comment comment = new Comment();
        comment.setContent(createCommentRequest.getContent());
        comment.setPost(post);
        return commentDtoConverter.convert(commentRepository.save(comment));
    }
}
