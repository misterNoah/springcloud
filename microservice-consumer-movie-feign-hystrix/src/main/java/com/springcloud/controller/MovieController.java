package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.User;
import com.springcloud.feign.UserFeignClient;

@RestController
public class MovieController {
	
	@Autowired
	private UserFeignClient userFeignConfig;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
	    return userFeignConfig.findById(id);
	}
}
