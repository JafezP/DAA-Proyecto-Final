package com.institute.order.infrastructure.adapter.customer;

import com.institute.order.domain.model.customer.Customer;
import com.institute.order.domain.model.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CustomerAdapter implements CustomerRepository {

    private final RestTemplate restTemplate;

    @Override
    public Customer findById(String uid) {
        String url = "http://localhost:8081/api/v1/institute/customer/" + uid;
        CustomerData customerData = restTemplate.getForObject(url, CustomerData.class);
        return CustomerMapper.MAPPER.toDomain(customerData);
    }
}
