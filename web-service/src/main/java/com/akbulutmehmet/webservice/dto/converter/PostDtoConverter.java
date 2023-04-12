package com.akbulutmehmet.webservice.dto.converter;

import com.akbulutmehmet.webservice.dto.response.CommentDto;
import com.akbulutmehmet.webservice.dto.response.PostDto;
import com.akbulutmehmet.webservice.model.Comment;
import com.akbulutmehmet.webservice.model.Post;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PostDtoConverter {
    private final CommentDtoConverter commentDtoConverter;

    public PostDtoConverter(CommentDtoConverter commentDtoConverter) {
        this.commentDtoConverter = commentDtoConverter;
    }

    public PostDto convert(Post post) {
        Set<CommentDto> commentDtoSet = null;
        if(post.getCommentSet() != null) {
            commentDtoSet = post.getCommentSet().stream().map((comment) -> commentDtoConverter.convert(comment)).collect(Collectors.toSet());
        }
        return new PostDto(post.getId(),post.getContent(),commentDtoSet);
    }
}
