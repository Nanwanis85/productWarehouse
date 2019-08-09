package com.product.warehouse.controller;

import java.util.List;

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

import com.product.warehouse.model.ProductWareHouseReciept;
import com.product.warehouse.service.ProductRecieptWarehouseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/productwarehouse/reciept")
@Api(value = "/v1/productwarehouse/reciept", tags = { "01 - Product Reciept WareHouse Management", })
public class ProductRecieptWarehouseController {
	
	@Autowired
	private ProductRecieptWarehouseService productRecieptWarehouseService;
	
	@ApiOperation(value = "Search Product", notes = "Search Products slot using Code Id from WareHouse", response = ResponseEntity.class)
	@GetMapping(path="/search/productslot/byproductcode",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Created", response=ResponseEntity.class),
			@ApiResponse(code=500, message="Internal Server Error"),
			@ApiResponse(code=422, message="Validation Error")
	})
	public ResponseEntity<Integer> searchProductByCode(String productCode) {
		Integer slotNo = productRecieptWarehouseService.searchProductByCode(productCode);
		return ResponseEntity.ok(slotNo);
	}
	
	@ApiOperation(value = "Search Product", notes = "Search All Products Slot using Color from WareHouse", response = ResponseEntity.class)
	@ GetMapping(path="/search/allproductslot/bycolor",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Created", response=ResponseEntity.class),
			@ApiResponse(code=500, message="Internal Server Error"),
			@ApiResponse(code=422, message="Validation Error")
	})
	public ResponseEntity<List<Integer>> searchProductSlotByColor(String colorName){
		return ResponseEntity.ok(productRecieptWarehouseService.searchProductsSlotNoByColor(colorName));
	}

}
