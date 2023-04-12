package com.akbulutmehmet.webservice.mapper;

import com.akbulutmehmet.webservice.dto.request.CreateCategoryRequest;
import com.akbulutmehmet.webservice.dto.response.CategoryDto;
import com.akbulutmehmet.webservice.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ICategoryMapper {
    Category toCategory(CreateCategoryRequest createCategoryRequest);

}
