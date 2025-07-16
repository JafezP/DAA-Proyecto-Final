package com.institute.Chef.domain.model;

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
