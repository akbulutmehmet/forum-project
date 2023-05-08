package com.akbulutmehmet.webservice.dto.converter;

import com.akbulutmehmet.webservice.dto.response.CommentDto;
import com.akbulutmehmet.webservice.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentDtoConverter {
    public CommentDto convert(Comment comment){
        return new CommentDto(comment.getId(), comment.getContent(),comment.getUserId());
    }
}
