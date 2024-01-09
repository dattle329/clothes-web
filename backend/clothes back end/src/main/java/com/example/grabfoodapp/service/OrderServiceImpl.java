package com.example.grabfoodapp.service;

import com.example.grabfoodapp.dto.OrderDto;
import com.example.grabfoodapp.entity.Order;
import com.example.grabfoodapp.form.OrderCreateForm;
import com.example.grabfoodapp.form.OrderUpdateForm;
import com.example.grabfoodapp.map.OrderMapper;
import com.example.grabfoodapp.repository.OrderRepository;
import com.example.grabfoodapp.repository.ProductRepository;
import com.example.grabfoodapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public Page<OrderDto> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable).map(OrderMapper::map);
    }

    @Override
    public OrderDto create(OrderCreateForm form, Long userId, Long productId) {
        var order = OrderMapper.map(form);
        order.setUser(userRepository.findById(userId).get());
        order.setProduct(productRepository.findById(productId).get());
        var savedOrder = orderRepository.save(order);
        return OrderMapper.map(savedOrder);
    }

//        @Override
//    public Order create(OrderCreateForm form, Long userId, Long productId) {
//        var order = OrderMapper.map(form);
//        order.setUser(userRepository.findById(userId).get());
//        order.setProduct(productRepository.findById(productId).get());
//        return order;
//    }


    @Override
    public OrderDto update(OrderUpdateForm form) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
