package com.cocou.mc.mclodging.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocou.mc.mclodging.userservice.entity.Users;
import com.cocou.mc.mclodging.userservice.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	 @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@RequestBody Users user) {
        // Check if username already exists
        if (userService.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().build();
        }

        // Create user
        Users createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }
}
