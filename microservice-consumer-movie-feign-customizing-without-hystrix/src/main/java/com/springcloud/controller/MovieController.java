package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.User;
import com.springcloud.feign.FeignClient2;
import com.springcloud.feign.UserFeignClient;



@RestController
public class MovieController {
	
	@Autowired
	private UserFeignClient userFeignConfig;
	
	@Autowired
	private FeignClient2 feignClient2;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
	    return userFeignConfig.findById(id);
	}
	
	@GetMapping("/{serviceName}")
	public String findServiceName(@PathVariable String serviceName){
		return feignClient2.findServiceName(serviceName);
	}
	
}
