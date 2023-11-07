package com.products.service.exception;

public class ProductNotFoundException extends RuntimeException{

	private String message;

	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(String message) {
		super(message);
		this.message = message;
	}	

}
