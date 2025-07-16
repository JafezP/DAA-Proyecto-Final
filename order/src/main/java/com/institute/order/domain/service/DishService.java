package com.institute.order.domain.service;

import com.institute.order.domain.model.dish.Dish;

import java.util.List;

public interface DishService {
    List<Dish> findAll();
    Dish findById(String id);
    Dish save(Dish dish);
}
