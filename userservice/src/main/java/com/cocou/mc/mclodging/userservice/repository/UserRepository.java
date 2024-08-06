package com.cocou.mc.mclodging.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cocou.mc.mclodging.userservice.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	Users findByUsername(String username);
}
