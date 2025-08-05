package com.institute.chef.domain.model;

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
