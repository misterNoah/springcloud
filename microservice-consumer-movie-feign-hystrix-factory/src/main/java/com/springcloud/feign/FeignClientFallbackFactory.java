package com.springcloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.springcloud.entity.User;

import feign.hystrix.FallbackFactory;

@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{

	private static final Logger Logger = LoggerFactory.getLogger(FeignClientFallbackFactory.class);
	
	@Override
	public UserFeignClient create(Throwable cause) {
		FeignClientFallbackFactory.Logger.info("fallback reason:" + cause.getMessage());
		
		return new UserFeignClientWithFactory() {
			@Override
			public User findById(Long id) {
				User user = new User();
				user.setId(-1L);
				
				return user;
			}
		};
	}

}
