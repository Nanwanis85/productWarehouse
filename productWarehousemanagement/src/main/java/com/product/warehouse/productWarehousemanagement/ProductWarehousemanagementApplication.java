package com.product.warehouse.productWarehousemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = { "com.product.warehouse.model" })
@SpringBootApplication(scanBasePackages= {"com.product.warehouse.controller", "com.product.warehouse.service, com.product.warehouse.shell"})
@EnableJpaRepositories(basePackages = {"com.product.warehouse.repository"})
public class ProductWarehousemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductWarehousemanagementApplication.class, args);
	}
	
}
