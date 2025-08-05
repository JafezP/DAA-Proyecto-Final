package com.institute.order.domain.model.customer;

public record Customer(
        String uid,
        String documentNumber,
        String name,
        String lastName,
        String phone,
        String email,
        int active
) {
}
