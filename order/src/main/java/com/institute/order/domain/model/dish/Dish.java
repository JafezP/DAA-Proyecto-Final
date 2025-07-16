package com.institute.order.domain.model.dish;

public record Dish(
        String uid,
        String name,
        String description,
        Double price
) {
}
