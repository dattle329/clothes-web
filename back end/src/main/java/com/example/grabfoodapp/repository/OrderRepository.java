package com.example.grabfoodapp.repository;

import com.example.grabfoodapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
