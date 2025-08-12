package com.institute.order.infrastructure.adapter.chef;

import com.institute.order.domain.model.chef.Chef;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChefMapper {

    ChefMapper MAPPER = Mappers.getMapper(ChefMapper.class);

    Chef toDomain(ChefData entity);

    ChefData toEntity(Chef domain);
}
