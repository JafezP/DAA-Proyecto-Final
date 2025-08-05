package com.institute.order.infrastructure.adapter.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerData {
    private String uid;
    private String documentNumber;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private int active;
}
