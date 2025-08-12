package com.institute.chef.infrastructure.adapter;

import com.institute.chef.domain.model.Chef;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChefMapper {

    ChefMapper MAPPER = Mappers.getMapper(ChefMapper.class);

    Chef toDomain(ChefData entity);

    ChefData toEntity(Chef domain);
}
