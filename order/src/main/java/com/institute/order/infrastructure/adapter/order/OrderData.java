package com.institute.order.infrastructure.adapter.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderD")
public class OrderData {

    @Id
    @Column(length = 40)
    private String uid;

    @Column(name = "uid_dish", length = 40)
    private String uidDish;

    @Column(name = "uid_chef", length = 40)
    private String uidChef;
}
