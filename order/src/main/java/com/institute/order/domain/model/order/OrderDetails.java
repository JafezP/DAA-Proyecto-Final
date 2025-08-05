package com.institute.order.domain.model.order;

public record OrderDetails(
        Long uid,
        String uidOrder,
        String uidCustomer
) {
}
