package com.institute.order.infrastructure.adapter.order;

import com.institute.order.domain.model.order.OrderDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderDetailsMapper {
    OrderDetailsMapper MAPPER = Mappers.getMapper(OrderDetailsMapper.class);

    OrderDetails toModel(OrderDetailsData entity);
    OrderDetailsData toData(OrderDetails model);
}
