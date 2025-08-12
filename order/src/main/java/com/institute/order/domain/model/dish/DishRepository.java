package com.institute.order.domain.model.dish;

import java.util.List;

public interface DishRepository {

    List<Dish> findAll();

    Dish findById(String uid);

    Dish save(Dish dish);

    Dish update(String uid, Dish dish);

    void deleteById(String uid);
}
