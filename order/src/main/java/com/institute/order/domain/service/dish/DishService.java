package com.institute.order.domain.service.dish;

import com.institute.order.domain.model.dish.Dish;

import java.util.List;

public interface DishService {

    List<Dish> findAll();

    Dish findById(String uid);

    Dish save(Dish dish);

    Dish update(String uid, Dish dish);

    void deleteById(String uid);
}
