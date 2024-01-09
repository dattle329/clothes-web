package com.example.grabfoodapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
        private String name;

    @Column(name = "img", length = 500, nullable = false)
    private String img;

    @Column(name = "price", length = 30, nullable = false)
    private Long price;
}
