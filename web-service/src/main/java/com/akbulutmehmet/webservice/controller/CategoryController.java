package com.akbulutmehmet.webservice.controller;

import com.akbulutmehmet.webservice.dto.request.CreateCategoryRequest;
import com.akbulutmehmet.webservice.dto.response.CategoryDto;
import com.akbulutmehmet.webservice.model.Category;
import com.akbulutmehmet.webservice.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping(value = "/createCategory")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CreateCategoryRequest createCategoryRequest){
      return ResponseEntity.ok(categoryService.createCategory(createCategoryRequest));
    }
    @GetMapping(value = "/listCategory")
    public ResponseEntity<Set<CategoryDto>> listCategory(){
        return ResponseEntity.ok(categoryService.listCategory());
    }
}