package com.institute.customer.infrastructure.adapter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDataRepository extends JpaRepository<CustomerData, String> {
}
