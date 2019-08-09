package com.product.warehouse.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.product.warehouse.exception.ProductWarehouseException;
import com.product.warehouse.model.Product;
import com.product.warehouse.service.ProductWarehouseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/productwarehouse")
@Api(value = "/v1/productwarehouse", tags = { "01 - Product WareHouse Management", })
public class ProductWarehouseController {
	
	@Autowired
	private ProductWarehouseService productWarehouseService;

	@ApiOperation(value = "Add Product", notes = "Add Product to WareHouse", response = ResponseEntity.class)
	@PostMapping(path="/addproduct",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Created", response=ResponseEntity.class),
			@ApiResponse(code=500, message="Internal Server Error"),
			@ApiResponse(code=422, message="Validation Error")
	})
	@ResponseStatus(HttpStatus.CREATED)
	public int addProduct(@RequestBody Product product) throws ProductWarehouseException {
		int id = productWarehouseService.addProduct(product);
		return id;
	}
	
	@ApiOperation(value = "Search Product", notes = "Search Products ByColor from WareHouse", response = ResponseEntity.class)
	@GetMapping(path="/search/allproduct/bycolor",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Created", response=ResponseEntity.class),
			@ApiResponse(code=500, message="Internal Server Error"),
			@ApiResponse(code=422, message="Validation Error")
	})
	public ResponseEntity<List<Product>> searchProductsByColor(String colorName) {
		List<Product> productList = productWarehouseService.searchProductByColorName(colorName);
		return ResponseEntity.ok(productList);
	}
	
}
