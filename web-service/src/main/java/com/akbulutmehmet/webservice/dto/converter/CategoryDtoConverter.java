package com.akbulutmehmet.webservice.dto.converter;

import com.akbulutmehmet.webservice.dto.response.CategoryDto;
import com.akbulutmehmet.webservice.dto.response.PostDto;
import com.akbulutmehmet.webservice.model.Category;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CategoryDtoConverter {
    private final PostDtoConverter postDtoConverter;

    public CategoryDtoConverter(PostDtoConverter postDtoConverter) {
        this.postDtoConverter = postDtoConverter;
    }

    public CategoryDto convert(Category category) {
        Set<PostDto> postDtoSet = category.getPosts().stream().map((post) -> postDtoConverter.convert(post)).collect(Collectors.toSet());
        return new CategoryDto(category.getId(),category.getTitle(), category.getDescription(),category.getUserId(), postDtoSet);
    }
}
