package com.product.warehouse.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.warehouse.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
	
	public List<Product> findAllByProductColor(String productColor);
	
	public Product findByProductCode(String productCode);

}
