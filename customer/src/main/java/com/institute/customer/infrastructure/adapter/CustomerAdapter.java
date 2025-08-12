package com.institute.customer.infrastructure.adapter;

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
                .map(CustomerMapper.MAPPER::toDomain)
                .toList();
    }

    @Override
    public Customer findById(String uid) {
        return customerDataRepository.findById(uid)
                .filter(customerData -> customerData.getActive() == 1)
                .map(CustomerMapper.MAPPER::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found or inactive: " + uid));
    }

    @Override
    public Customer save(Customer customer) {
        CustomerData customerData = customerDataRepository.save(CustomerMapper.MAPPER.toEntity(customer));
        return CustomerMapper.MAPPER.toDomain(customerData);
    }

    @Override
    public Customer update(String uid, Customer customer) {
        CustomerData currentCustomerData = customerDataRepository.findById(uid).
                orElseThrow(() -> new EntityNotFoundException("Customer not found or inactive: " + uid));

        CustomerData updatedCustomerData = CustomerMapper.MAPPER.toEntity(customer);
        updatedCustomerData.setUid(currentCustomerData.getUid());
        return CustomerMapper.MAPPER.toDomain(customerDataRepository.save(updatedCustomerData));
    }

    @Override
    public void deleteById(String uid) {
        customerDataRepository.findById(uid)
                .filter(customerData -> customerData.getActive() == 1)
                .ifPresent(customerData -> {
                    customerData.setActive(0);
                    customerDataRepository.save(customerData);
                });
    }
}
