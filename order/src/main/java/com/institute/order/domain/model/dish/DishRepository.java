package com.institute.order.domain.model.dish;

import java.util.List;

public interface DishRepository {
    List<Dish> findAll();
    Dish findById(String id);
    Dish save(Dish dish);
}
