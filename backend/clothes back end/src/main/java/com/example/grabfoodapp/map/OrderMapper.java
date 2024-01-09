package com.example.grabfoodapp.map;

import com.example.grabfoodapp.dto.OrderDto;
import com.example.grabfoodapp.entity.Order;
import com.example.grabfoodapp.form.OrderCreateForm;

public class OrderMapper {
    public static Order map(OrderCreateForm form){
        var order = new Order();
        order.setQuantity(form.getQuantity());
        return order;
    }

    public static OrderDto map(Order order){
        var dto = new OrderDto();
        dto.setProduct(order.getProduct());
        dto.setQuantity(order.getQuantity());
        return dto;
    }
}
