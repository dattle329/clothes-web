package com.example.grabfoodapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity", length = 100, nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "user_id",
                referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id",
            referencedColumnName = "id")
    private Product product;
}
