package com.example.grabfoodapp.controller;

import com.example.grabfoodapp.dto.OrderDto;
import com.example.grabfoodapp.entity.Order;
import com.example.grabfoodapp.form.OrderCreateForm;
import com.example.grabfoodapp.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@AllArgsConstructor
@CrossOrigin("*")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/api/v1/orders")
    public Page<OrderDto> findAll(Pageable pageable){
        return orderService.findAll(pageable);
    }

    @PostMapping("/api/v1/user/{userId}/product/{productId}/order")
    public OrderDto create(@RequestBody OrderCreateForm form, @PathVariable("userId") Long userId,@PathVariable("productId") Long productId){
        return orderService.create(form, userId, productId);
    }

//    @PostMapping("/api/v1/user/{userId}/product/{productId}/order")
//    public Order create(@RequestBody OrderCreateForm form, @PathVariable("userId") Long userId, @PathVariable("productId") Long productId){
//        return orderService.create(form, userId, productId);
//    }
}
