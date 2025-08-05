package com.institute.order.infrastructure.adapter.dish;

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
@Table(name = "curso")
public class DishData {

    @Id
    @Column(name = "uid", length = 40)
    private String uid;

    @Column(name = "name", length = 60)
    private String name;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "price")
    private Double price;
}
