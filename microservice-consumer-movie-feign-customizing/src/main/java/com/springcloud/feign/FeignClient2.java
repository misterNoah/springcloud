package com.springcloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.feignConfig.FeignConfiguration2;

@FeignClient(name="xxxx", url="http://localhost:8761/",configuration=FeignConfiguration2.class)
public interface FeignClient2 {
	
	@RequestMapping(value="/eureka/apps/{serviceName}")
	public String findServiceName(@PathVariable("serviceName") String serviceName);

}
