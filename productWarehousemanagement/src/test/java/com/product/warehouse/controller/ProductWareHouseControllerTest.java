package com.product.warehouse.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.warehouse.model.Product;
import com.product.warehouse.service.ProductWarehouseService;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class ProductWareHouseControllerTest extends TestCase {
	@InjectMocks
	private ProductWarehouseController productWareHouseController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	ProductWarehouseService productWarehouseService;
	
	private byte[] request;
	
	@Before
	public void setUp() throws Exception {
		Product product = new Product();
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(productWareHouseController).build();
		request = new ObjectMapper().writeValueAsString(product).getBytes();
	}
	
	@Test
	public void testaddProduct201Response() throws Exception {
		doReturn(1).when(productWarehouseService).addProduct(any());		
		this.mockMvc
				.perform(post("/v1/productwarehouse/addproduct").content(request)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(201)); 
	}

}
