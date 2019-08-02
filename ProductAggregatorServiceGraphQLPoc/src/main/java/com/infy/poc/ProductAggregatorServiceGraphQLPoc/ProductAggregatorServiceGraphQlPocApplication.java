package com.infy.poc.ProductAggregatorServiceGraphQLPoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@ComponentScan(basePackages="com.infy.poc")
public class ProductAggregatorServiceGraphQlPocApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ProductAggregatorServiceGraphQlPocApplication.class, args);
	}
	 @Bean
	    public RestTemplate getRestTemplate() {
	       return new RestTemplate();
	    }
}
