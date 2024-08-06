package com.cocou.mc.mclodging.produitservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cocou.mc.mclodging.produitservice.model.Product;


public interface ProductDao extends JpaRepository<Product, Long> {

}