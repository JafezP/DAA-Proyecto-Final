package com.institute.Chef.infrastructure.adapter;

import com.institute.Chef.domain.model.Chef;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChefMapper {
    ChefMapper MAPPER = org.mapstruct.factory.Mappers.getMapper(ChefMapper.class);
    Chef toModel(ChefData entity);
    ChefData toEntity(Chef model);
}
