package com.akbulutmehmet.webservice.service;


import com.akbulutmehmet.webservice.dto.converter.CategoryDtoConverter;
import com.akbulutmehmet.webservice.dto.request.CreateCategoryRequest;
import com.akbulutmehmet.webservice.dto.request.UpdateCategoryRequest;
import com.akbulutmehmet.webservice.dto.response.CategoryDto;
import com.akbulutmehmet.webservice.exception.CategoryException;
import com.akbulutmehmet.webservice.model.Category;
import com.akbulutmehmet.webservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
public class CategoryService {
    private final CategoryRepository categoryRepository;

    private final CategoryDtoConverter categoryDtoConverter;

    public CategoryService(CategoryRepository categoryRepository, CategoryDtoConverter categoryDtoConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoConverter = categoryDtoConverter;
    }

    @Transactional(readOnly = false)
    public Category createCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = new Category();
        category.setDescription(createCategoryRequest.getDescription());
        category.setTitle(createCategoryRequest.getTitle());
        category.setUserId(createCategoryRequest.getUserId());
        return categoryRepository.save(category);
    }

    public Set<CategoryDto> listCategory() {
        return categoryRepository.findAll().stream().map((category) -> categoryDtoConverter.convert(category) ).collect(Collectors.toSet());
    }

    public Category findById(String categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryException("Category not found"));
    }

    public CategoryDto getCategoryWithId(String id) {
        return categoryDtoConverter.convert(findById(id));
    }
    @Transactional(readOnly = false)
    public CategoryDto updateCategory(UpdateCategoryRequest updateCategoryRequest) {
        Category category = findById(updateCategoryRequest.getId());
        category.setTitle(updateCategoryRequest.getTitle());
        category.setDescription(updateCategoryRequest.getDescription());
        return categoryDtoConverter.convert(categoryRepository.save(category));
    }
}
