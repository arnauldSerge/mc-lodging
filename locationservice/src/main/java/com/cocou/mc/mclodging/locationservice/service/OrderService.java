package com.cocou.mc.mclodging.locationservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.cocou.mc.mclodging.locationservice.controller.OrderController;
import com.cocou.mc.mclodging.locationservice.model.Order;
import com.cocou.mc.mclodging.locationservice.repository.OrderRepository;

@Service
public class OrderService {
	
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    
    public OrderService() {
        logger.info("OrderService initialized");
    }

    @Autowired
    private OrderRepository orderRepository;

    public List  <Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        // Implement order creation logic
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}