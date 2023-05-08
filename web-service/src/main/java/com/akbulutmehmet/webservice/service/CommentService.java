package com.akbulutmehmet.webservice.service;

import com.akbulutmehmet.webservice.dto.converter.CommentDtoConverter;
import com.akbulutmehmet.webservice.dto.request.CreateCommentRequest;
import com.akbulutmehmet.webservice.dto.request.UpdateCommentRequest;
import com.akbulutmehmet.webservice.dto.response.CommentDto;
import com.akbulutmehmet.webservice.exception.CommentException;
import com.akbulutmehmet.webservice.model.Comment;
import com.akbulutmehmet.webservice.model.Post;
import com.akbulutmehmet.webservice.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        comment.setUserId(createCommentRequest.getUserId());
        return commentDtoConverter.convert(commentRepository.save(comment));
    }

    public Comment findById(String id) {
        return commentRepository.findById(id).orElseThrow(() -> new CommentException("Comment not found!"));
    }
    @Transactional(readOnly = false)
    public CommentDto updateComment(UpdateCommentRequest updateCommentRequest) {
        Comment comment = findById(updateCommentRequest.getId());
        comment.setContent(updateCommentRequest.getContent());
        return commentDtoConverter.convert(commentRepository.save(comment));
    }
    @Transactional(readOnly = false)
    public void deleteComment(String id) {
        commentRepository.deleteById(id);
    }

    public List<CommentDto> getCommentsByPostId(String postId) {
        return  postService.findById(postId).getCommentSet().stream().map((comment) -> {
            return commentDtoConverter.convert(comment);
        }).collect(Collectors.toList());
    }
}
