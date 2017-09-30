package com.springcloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.feignConfig.FeignConfigration;
import com.springcloud.entity.User;

import feign.Param;
import feign.RequestLine;

@FeignClient(name="provider-user",configuration=FeignConfigration.class,fallback=HystrixClientFallback.class)
public interface UserFeignClient {
	
	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id);
	
}
