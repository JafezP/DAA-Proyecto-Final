package com.institute.order.infrastructure.adapter.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_details")
public class OrderDetailsData {

    @Id
    @GeneratedValue
    private Long uid;

    @Column(name = "uid_order", length = 40)
    private String uidOrder;

    @Column(name = "uid_customer", length = 40)
    private String uidCustomer;
}
