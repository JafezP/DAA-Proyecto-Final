package com.institute.order.infrastructure.adapter.order;

import com.institute.order.domain.model.order.Order;
import com.institute.order.domain.model.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderAdapter implements OrderRepository {

    private final OrderDataRepository orderDataRepository;

    @Override
    public List<Order> findAll() {
        return orderDataRepository
                .findAll()
                .stream()
                .map(OrderMapper.MAPPER::toModel)
                .toList();
    }

    @Override
    public Order findById(String uid) {
        Optional<OrderData> optional = orderDataRepository.findById(uid);
        return optional.map(OrderMapper.MAPPER::toModel).orElse(null);
    }

    @Override
    public Order findByChefAndDish(String uidChef, String uidDish) {
        return null;
    }

    @Override
    public Order save(Order order) {
        OrderData data = OrderMapper.MAPPER.toData(order);
        return OrderMapper.MAPPER.toModel(orderDataRepository.save(data));
    }
}
