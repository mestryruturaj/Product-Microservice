package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMicroserviceApplication.class, args);
	}

}
/*
* TODO
*  1) Add controller, service layers
*  2) Implement custom httpclient
*  3) Put, patch, delete should be implemented
* */