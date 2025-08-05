package com.institute.order.domain.service.order;

import com.institute.order.domain.model.chef.Chef;
import com.institute.order.domain.model.chef.ChefRepository;
import com.institute.order.domain.model.dish.Dish;
import com.institute.order.domain.model.dish.DishRepository;
import com.institute.order.domain.model.order.Order;
import com.institute.order.domain.model.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final DishRepository dishRepository;
    private final ChefRepository chefRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(String uid) {
        return orderRepository.findById(uid);
    }

    @Override
    public Order save(Order order) {
        Dish dish = dishRepository.findById(order.uid()); //Pendiente uidDish()
        Chef chef = chefRepository.findById(order.uidChef());
        if(dish != null && chef != null){
            return orderRepository.save(order);
        }
        return null;
    }
}
