package com.akbulutmehmet.webservice.service;


import com.akbulutmehmet.webservice.dto.converter.CategoryDtoConverter;
import com.akbulutmehmet.webservice.dto.request.CreateCategoryRequest;
import com.akbulutmehmet.webservice.dto.response.CategoryDto;
import com.akbulutmehmet.webservice.exception.CategoryException;
import com.akbulutmehmet.webservice.mapper.ICategoryMapper;
import com.akbulutmehmet.webservice.model.Category;
import com.akbulutmehmet.webservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ICategoryMapper categoryMapper;
    private final CategoryDtoConverter categoryDtoConverter;

    public CategoryService(CategoryRepository categoryRepository, ICategoryMapper categoryMapper, CategoryDtoConverter categoryDtoConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.categoryDtoConverter = categoryDtoConverter;
    }

    @Transactional(readOnly = false)
    public Category createCategory(CreateCategoryRequest createCategoryRequest) {
        return categoryRepository.save(categoryMapper.toCategory(createCategoryRequest));
    }

    public Set<CategoryDto> listCategory() {
        return categoryRepository.findAll().stream().map((category) -> categoryDtoConverter.convert(category) ).collect(Collectors.toSet());
    }

    public Category findById(String categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryException("Category not found"));
    }
}
