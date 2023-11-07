package com.products.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.service.entities.Product;
import com.products.service.exception.ProductAlreadyExistsException;
import com.products.service.exception.ProductNotFoundException;
import com.products.service.repository.ProductsRepository;

@Service
public class ProductServiceImpl implements ProductService 
{
	@Autowired
	private ProductsRepository repo;
	
	@Override
	public List<Product> GetAllProducts() {
		return repo.findAll();
	}

	@Override
	public Product addProduct(Product prd) {
		return repo.save(prd);
	}

	@Override
	public Product updateProduct(Product prd) {
		if(repo.findById(prd.getId()).isEmpty()) {
			throw new ProductNotFoundException("Product Not Found!");
		}
		return repo.save(prd);
	}

	@Override
	public void deleteProduct(Product prd) {
		if(repo.findById(prd.getId()).isEmpty()) {
			throw new ProductNotFoundException("Product Not Found!");
		}
		repo.delete(prd);
	}

	@Override
	public Product getProductById(int id) {
		if(repo.findById(id).isEmpty()) {
			throw new ProductNotFoundException("Product Not Found!");
		}
		return repo.findById(id).get();
	}
	
	@Override
	public List<Product> searchProducts(String query) {
		List<Product> products = repo.searchProductsSQL(query);
		if(products == null || products.isEmpty()) {
			throw new ProductNotFoundException("Product Not Found!");
		}
		return products;
	}

}