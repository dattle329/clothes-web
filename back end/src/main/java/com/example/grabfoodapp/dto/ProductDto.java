package com.example.grabfoodapp.dto;

import com.example.grabfoodapp.entity.Product;
import com.example.grabfoodapp.form.ProductCreateForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private String img;
    private Long price;
}
