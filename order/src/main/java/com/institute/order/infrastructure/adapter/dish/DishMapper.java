package com.institute.order.infrastructure.adapter.dish;

import com.institute.order.domain.model.dish.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DishMapper {
    
    DishMapper MAPPER = Mappers.getMapper(DishMapper.class);

    Dish toModel(DishData entity);

    DishData toData(Dish model);
}
