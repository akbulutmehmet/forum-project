package com.akbulutmehmet.webservice.mapper;

import com.akbulutmehmet.webservice.dto.request.CreateCategoryRequest;
import com.akbulutmehmet.webservice.dto.response.CategoryDto;
import com.akbulutmehmet.webservice.model.Category;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ICategoryMapper {

    Category toCategory(CreateCategoryRequest createCategoryRequest);

}
