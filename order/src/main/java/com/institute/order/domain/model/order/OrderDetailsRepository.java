package com.institute.order.domain.model.order;

import java.util.List;

public interface OrderDetailsRepository {
    
    List<OrderDetails> findByOrderId(String uidOrder);
    
    List<OrderDetails> findByCustomerId(String uidCustomer);
    
    OrderDetails save(OrderDetails aperturaDetalle);
}
