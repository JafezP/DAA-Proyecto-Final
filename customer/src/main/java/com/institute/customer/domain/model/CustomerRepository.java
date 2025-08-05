package com.institute.customer.domain.model;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    Customer findById(String uid);

    Customer save(Customer customer);

    Customer update(String uid, Customer customer);

    void deleteById(String uid);
}
