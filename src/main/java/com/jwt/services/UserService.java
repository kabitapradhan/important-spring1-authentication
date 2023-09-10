package com.jwt.services;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.entity.User;
import com.jwt.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUser(){
		return this.userRepo.findAll();
	}
		
	public User createUser(User user){
		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println(user);
		User user2 = this.userRepo.save(user);
		
		return user2;
	}
}
