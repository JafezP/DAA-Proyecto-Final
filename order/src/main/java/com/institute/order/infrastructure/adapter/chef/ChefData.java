package com.institute.order.infrastructure.adapter.chef;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChefData {
    private String uid;
    private String documentNumber;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private int active;
}
