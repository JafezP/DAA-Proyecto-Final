package com.institute.order.domain.model.chef;

public record Chef(
        String uid,
        String documentNumber,
        String name,
        String lastName,
        String phone,
        String email,
        int active
) {
}
