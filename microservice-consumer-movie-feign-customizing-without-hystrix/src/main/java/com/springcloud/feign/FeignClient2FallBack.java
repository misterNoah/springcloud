package com.springcloud.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignClient2FallBack implements FeignClient2 {

	@Override
	public String findServiceName(String serviceName) {
		return "haha";
	}

}
