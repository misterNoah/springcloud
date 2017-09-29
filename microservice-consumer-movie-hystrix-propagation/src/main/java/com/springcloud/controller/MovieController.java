package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.entity.User;



@RestController
public class MovieController {
	
  @Autowired
  private RestTemplate restTemplate;


  @GetMapping("/movie/{id}")
  @HystrixCommand(fallbackMethod="findCallback",
  	commandProperties={@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")})
  public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject("http://provider-user/simple/" + id, User.class);
  }
  
  public User findCallback(Long id){
	  User user = new User();
	  user.setId(0L);
	  return user;
  }
}
