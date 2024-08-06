package com.cocou.mc.mclodging.userservice.service;

//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cocou.mc.mclodging.userservice.entity.Users;
import com.cocou.mc.mclodging.userservice.repository.UserRepository;

import lombok.Data;

@Service
@Data 
public class UserService {
	private final UserRepository userRepository;
	//private final PasswordEncoder passwordEncoder;
	
	public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Users createUser(Users user) {
        // Encode password before saving
       // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
