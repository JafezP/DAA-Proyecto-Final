package com.institute.customer.infrastructure.adapter.customer;

import com.institute.customer.domain.model.Customer;
import com.institute.customer.domain.model.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerAdapter implements CustomerRepository {

    private final CustomerDataRepository customerDataRepository;

    @Override
    public List<Customer> findAll() {
        return customerDataRepository.findAll()
                .stream()
                .filter(customerData -> customerData.getActive() != 0)
                .map(CustomerMapper.MAPPER::toModel)
                .toList();
    }

    @Override
    public Customer findById(String uid) {
        return customerDataRepository.findById(uid)
                .filter(customerData -> customerData.getActive() == 1)
                .map(CustomerMapper.MAPPER::toModel)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found or inactive: " + uid));
    }

    @Override
    public Customer save(Customer customer) {
        CustomerData customerData = customerDataRepository.save(CustomerMapper.MAPPER.toEntity(customer));
        return CustomerMapper.MAPPER.toModel(customerData);
    }

    @Override
    public Customer update(String uid, Customer customer) {
        CustomerData existing = customerDataRepository.findById(uid).
                orElseThrow(() -> new EntityNotFoundException("Customer not found: " + uid));

        CustomerData update = CustomerMapper.MAPPER.toEntity(customer);
        update.setUid(existing.getUid());
        return CustomerMapper.MAPPER.toModel(customerDataRepository.save(update));
    }

    @Override
    public void deleteById(String uid) {
        customerDataRepository.findById(uid)
                .filter(c -> c.getActive() == 1)
                .ifPresent(customerData -> {
                    customerData.setActive(0);
                    customerDataRepository.save(customerData);
                });
    }
}
