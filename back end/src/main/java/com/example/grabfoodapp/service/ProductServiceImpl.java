package com.example.grabfoodapp.service;

import com.example.grabfoodapp.dto.ProductDto;
import com.example.grabfoodapp.form.ProductCreateForm;
import com.example.grabfoodapp.form.ProductUpdateForm;
import com.example.grabfoodapp.map.ProductMapper;
import com.example.grabfoodapp.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override
    public Page<ProductDto> findAll(Pageable pageablege) {
        return productRepository.findAll(pageablege).map(ProductMapper::map);
    }

    @Override
    public ProductDto findById(Long id) {
        return productRepository.findById(id).map(ProductMapper::map).get();
    }

    @Override
    public ProductDto create(ProductCreateForm form) {
        var product = ProductMapper.map(form);
        var savedProduct = productRepository.save(product);
        return ProductMapper.map(savedProduct);
    }

    @Override
    public ProductDto update(ProductUpdateForm form, Long id) {
        var product = ProductMapper.map(form);
        product.setId(id);
        var savedProduct = productRepository.save(product);
        return ProductMapper.map(savedProduct);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
