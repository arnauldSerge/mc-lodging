package com.cocou.mc.mclodging.locationservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.cocou.mc.mclodging.locationservice.model.Order;
import com.cocou.mc.mclodging.locationservice.service.OrderService;

@RestController
@RequestMapping("api/orders")
@RefreshScope
public class OrderController {
	
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;
    
    public OrderController() {
        logger.info("OrderController initialized");
    }
   

   

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) {
        Order order = orderService.getOrderById(id);
        if(Objects.isNull(order)) {
        	throw new com.cocou.mc.mclodging.locationservice.exception.CommandeNotFoundException("Cette commande n'existe pas");
        }
         return ResponseEntity.notFound().build();
    }
    
    
    
    @PostMapping("createOrder")
    public //ResponseEntity<Order> 
    ResponseEntity<Order>  createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}
