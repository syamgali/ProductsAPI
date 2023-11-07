package com.products.service.exception;

public class ProductAlreadyExistsException extends RuntimeException{
	
	private String message;

	public ProductAlreadyExistsException() {
		super();
	}

	public ProductAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}	

}
