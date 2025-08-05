package com.institute.order.domain.service.order;

import com.institute.order.domain.model.order.OrderDetails;

import java.util.List;

public interface OrderDetailsService {

    List<OrderDetails> findByOrderId(String uidOrder);

    List<OrderDetails> findByCustomerId(String uidCustomer);

    OrderDetails save(OrderDetails orderDetails);
}
