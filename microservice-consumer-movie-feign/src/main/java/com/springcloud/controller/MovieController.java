package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.UserFeignClient;
import com.springcloud.entity.User;



@RestController
public class MovieController {
	
	@Autowired
	private UserFeignClient userFeignConfig;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
	    return userFeignConfig.findById(id);
	}
	
	@GetMapping("/user")
	public User postUser(User user){
		return userFeignConfig.postUser(user);
	}
	
	@GetMapping("/get-user")
	  public User getUser(User user){
		return userFeignConfig.getUser(user);
	}
}
