package com.institute.order.domain.service.order;

import com.institute.order.domain.model.order.Order;

import java.util.List;

public interface OrderService {
    
    List<Order> findAll();
    
    Order findById(String uid);
    
    Order save(Order order);
}
