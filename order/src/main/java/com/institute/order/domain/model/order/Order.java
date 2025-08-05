package com.institute.order.domain.model.order;

public record Order(
        String uid,
        String uidCustomer,
        String uidChef
) {
}
