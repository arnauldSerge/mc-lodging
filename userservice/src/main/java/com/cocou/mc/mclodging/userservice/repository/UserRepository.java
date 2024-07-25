package com.cocou.mc.mclodging.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cocou.mc.mclodging.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
