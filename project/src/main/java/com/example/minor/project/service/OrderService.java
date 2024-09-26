package com.example.minor.project.service;

import com.example.minor.project.models.entity.Orders;
import com.example.minor.project.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Orders saveOrUpdate(Orders order){
        return orderRepository.save(order);
    }
}
