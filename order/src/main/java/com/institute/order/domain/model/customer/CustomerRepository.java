package com.institute.order.domain.model.customer;

public interface CustomerRepository {
    Customer findById(String uid);
}
