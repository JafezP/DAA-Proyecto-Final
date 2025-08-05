package com.institute.order.domain.service.order;

import com.institute.order.domain.model.order.OrderDetails;
import com.institute.order.domain.model.order.OrderDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailsService{

    private final OrderDetailsRepository orderDetailsRepository;

    @Override
    public List<OrderDetails> findByOrderId(String uidOrder) {
        return orderDetailsRepository.findByOrderId(uidOrder);
    }

    @Override
    public List<OrderDetails> findByCustomerId(String uidCustomer) {
        return orderDetailsRepository.findByCustomerId(uidCustomer);
    }

    @Override
    public OrderDetails save(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }
}
