package com.cocou.mc.mclodging.locationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cocou.mc.mclodging.locationservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
