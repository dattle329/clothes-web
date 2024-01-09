package com.example.grabfoodapp.controller;

import com.example.grabfoodapp.dto.ProductDto;
import com.example.grabfoodapp.form.ProductCreateForm;
import com.example.grabfoodapp.form.ProductUpdateForm;
import com.example.grabfoodapp.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@AllArgsConstructor
@CrossOrigin("*")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/api/v1/products")
    public Page<ProductDto> findAll(Pageable pageable){
        return productService.findAll(pageable);
    }

    @GetMapping("/api/v1/product/{id}")
    public ProductDto findById(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @PostMapping("/api/v1/product")
    public ProductDto create(@RequestBody @Valid ProductCreateForm form){
        return productService.create(form);
    }

    @PutMapping("/api/v1/product/{id}")
    public ProductDto update(@RequestBody ProductUpdateForm form,@PathVariable("id") Long id){
        return productService.update(form, id);
    }

    @DeleteMapping("/api/v1/product/{id}")
    public void delete(@PathVariable("id") Long id){
         productService.delete(id);
    }
}
