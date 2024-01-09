package com.example.grabfoodapp.dto;

import com.example.grabfoodapp.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private Product product;
    private int quantity;
}
