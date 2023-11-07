package com.products.service.services;

import java.util.List;

import com.products.service.entities.Product;
import com.products.service.exception.ProductAlreadyExistsException;
import com.products.service.exception.ProductNotFoundException;

public interface ProductService {
	
	public List<Product> GetAllProducts();
	public Product addProduct(Product prd);
	public Product updateProduct(Product prd) throws ProductNotFoundException;
	public void deleteProduct(Product prd) throws ProductNotFoundException;
	public Product getProductById(int id) throws ProductNotFoundException;
	public List<Product> searchProducts(String query) throws ProductNotFoundException;

}
