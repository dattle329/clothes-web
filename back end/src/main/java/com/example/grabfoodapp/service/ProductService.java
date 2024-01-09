package com.example.grabfoodapp.service;

import com.example.grabfoodapp.dto.ProductDto;
import com.example.grabfoodapp.form.ProductCreateForm;
import com.example.grabfoodapp.form.ProductUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<ProductDto> findAll(Pageable pageablege);

    ProductDto findById(Long id);
    ProductDto create(ProductCreateForm form);

    ProductDto update(ProductUpdateForm form, Long id);

    void delete(Long id);
}
