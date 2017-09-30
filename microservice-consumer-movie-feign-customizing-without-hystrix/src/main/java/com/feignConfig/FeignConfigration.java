package com.feignConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

@Configuration
public class FeignConfigration {
	
	@Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

}
