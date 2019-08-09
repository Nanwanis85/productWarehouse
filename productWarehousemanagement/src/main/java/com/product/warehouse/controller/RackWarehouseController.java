package com.product.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.product.warehouse.model.Rack;
import com.product.warehouse.service.RackWarehouseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/rackwarehouse")
@Api(value = "/v1/rackwarehouse", tags = { "01 - Product Rack WareHouse Management", })
public class RackWarehouseController {
	
	@Autowired
	private RackWarehouseService rackService;

	@ApiOperation(value = "Add Racks", notes = "Add Racks to WareHouse", response = ResponseEntity.class)
	@PostMapping(path="/addrack",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Created", response=ResponseEntity.class),
			@ApiResponse(code=500, message="Internal Server Error"),
			@ApiResponse(code=422, message="Validation Error")
	})
	@ResponseStatus(HttpStatus.CREATED)
	public void addRacks(@RequestBody List<Rack> rackList) {
		rackService.addRacks(rackList);
	}
}
