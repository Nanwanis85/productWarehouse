package com.product.warehouse.exception;

import org.springframework.http.HttpStatus;

public class ProductWarehouseException extends Exception{

	private static final long serialVersionUID = 1L;

	private String correlationId;
	
	private HttpStatus statusCode;
	
	private String thrownByMethod;

	private String[] thrownByMethodArgs;
	
	public ProductWarehouseException(String statusMessage) {
		super(statusMessage);
	}

	public ProductWarehouseException(HttpStatus statusCode, String statusMessage) {
		super(statusMessage);
		this.statusCode = statusCode;
	}

	public ProductWarehouseException(HttpStatus statusCode, String statusMessage, Exception e) {
		super(statusMessage, e);
		this.statusCode = statusCode;
	}

}
