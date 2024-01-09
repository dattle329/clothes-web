package com.example.grabfoodapp.map;

import com.example.grabfoodapp.dto.ProductDto;
import com.example.grabfoodapp.entity.Product;
import com.example.grabfoodapp.form.ProductCreateForm;
import com.example.grabfoodapp.form.ProductUpdateForm;

public class ProductMapper {
    public static Product map(ProductCreateForm form){
        var product = new Product();
        product.setName(form.getName());
        product.setImg(form.getImg());
        product.setPrice(form.getPrice());
        return product;
    }

    public static Product map(ProductUpdateForm form){
        var product = new Product();
        product.setName(form.getName());
        product.setImg(form.getImg());
        product.setPrice(form.getPrice());
        return product;
    }

    public static ProductDto map(Product product){
        var dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setImg(product.getImg());
        dto.setPrice(product.getPrice());
        return dto;
    }
}
