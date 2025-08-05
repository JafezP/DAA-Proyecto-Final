package com.institute.order.infrastructure.adapter.dish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishDataRepository extends JpaRepository<DishData, String> {
}
