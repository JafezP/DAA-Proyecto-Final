package com.institute.customer.infrastructure.adapter;

import com.institute.customer.domain.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    Customer toDomain(CustomerData entity);

    CustomerData toEntity(Customer domain);
}
