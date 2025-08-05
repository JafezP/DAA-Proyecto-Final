package com.institute.order.infrastructure.adapter.customer;

import com.institute.order.domain.model.customer.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    Customer toDomain(CustomerData entity);

    CustomerData toEntity(Customer domain);
}
