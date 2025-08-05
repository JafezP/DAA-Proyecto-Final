package com.institute.order.infrastructure.adapter.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDataRepository extends JpaRepository<OrderData, String> {
}
