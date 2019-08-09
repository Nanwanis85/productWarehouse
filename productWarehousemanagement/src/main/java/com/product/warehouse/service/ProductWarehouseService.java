package com.product.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.warehouse.exception.ProductWarehouseException;
import com.product.warehouse.model.Product;
import com.product.warehouse.model.ProductWareHouseReciept;
import com.product.warehouse.repository.ProductRepository;

@Service
public class ProductWarehouseService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductRecieptWarehouseService productRecieptWarehouseService;
	
	public int addProduct(Product product) throws ProductWarehouseException {
		Product productDb = productRepository.save(product);
		ProductWareHouseReciept productReciept = new ProductWareHouseReciept();
		productReciept.setProduct(productDb);
		ProductWareHouseReciept wareHouseReciept= productRecieptWarehouseService.generateReciept(productReciept);
		return wareHouseReciept.getRack().getSlotNo();
	}
	
	public List<Product> searchProductByColorName(String colorName) {
		return productRepository.findAllByProductColor(colorName);
	}
	
	public Product searchProductByCode(String productCodeId) {
		return productRepository.findByProductCode(productCodeId);
	}
	

}
