package com.example.grabfoodapp.service;

import com.example.grabfoodapp.dto.OrderDto;
import com.example.grabfoodapp.entity.Order;
import com.example.grabfoodapp.form.OrderCreateForm;
import com.example.grabfoodapp.form.OrderUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Page<OrderDto> findAll(Pageable pageable);

    OrderDto create(OrderCreateForm form, Long userId, Long productId);

//    Order create(OrderCreateForm form, Long userId, Long productId);

    OrderDto update(OrderUpdateForm form);

    void delete(Long id);
}
