package com.cocou.mc.mclodging.userservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocou.mc.mclodging.userservice.entity.User;
import com.cocou.mc.mclodging.userservice.service.UserService;

import lombok.Data;

@RestController
@RequestMapping("/users")
@Data
public class UserController {
	private final UserService userService;
	
	 @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        // Check if username already exists
        if (userService.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().build();
        }

        // Create user
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }
}
