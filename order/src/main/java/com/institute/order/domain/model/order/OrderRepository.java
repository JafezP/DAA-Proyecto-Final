package com.institute.order.domain.model.order;

import java.util.List;

public interface OrderRepository {

    List<Order> findAll();

    Order findById(String uid);

    Order findByChefAndDish(String uidChef, String uidDish);

    Order save(Order apertura);
}
