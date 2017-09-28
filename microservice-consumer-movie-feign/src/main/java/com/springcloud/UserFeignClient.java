package com.springcloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.configuration.LogginConfig;
import com.springcloud.entity.User;

@FeignClient(name="provider-user",configuration=LogginConfig.class)
public interface UserFeignClient {
	
	@RequestMapping(value="/simple/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public User postUser(@RequestBody User user);
	
	@RequestMapping(value="/get-user",method=RequestMethod.GET)
	public User getUser(User user);

}
