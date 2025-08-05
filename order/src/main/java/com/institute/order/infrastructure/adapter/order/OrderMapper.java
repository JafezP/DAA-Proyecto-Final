package com.institute.order.infrastructure.adapter.order;

import com.institute.order.domain.model.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

    Order toModel(OrderData entity);

    OrderData toData(Order model);
}
