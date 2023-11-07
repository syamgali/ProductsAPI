package com.products.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.products.service.entities.Product;
import com.products.service.exception.ProductAlreadyExistsException;
import com.products.service.exception.ProductNotFoundException;
import com.products.service.services.ProductService;

@RestController
public class ProductController 
{
	@Autowired
	private ProductService serv;
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> GetAll()
	{
		List<Product> prds=serv.GetAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(prds);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> GetById(@PathVariable int id)
	{
		try {
			Product prd=serv.getProductById(id);
			return ResponseEntity.status(HttpStatus.OK).body(prd);
		} catch(ProductNotFoundException productNotFoundException) {
			return new ResponseEntity(productNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Product> Add(@RequestBody Product prd)
	{
		Product prdl=serv.addProduct(prd);
		return ResponseEntity.status(HttpStatus.CREATED).body(prdl);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Product> Update(@RequestBody Product prd)
	{
		try {
			Product prdl=serv.updateProduct(prd);
			return ResponseEntity.ok(prdl);
		} catch(ProductNotFoundException productNotFoundException) {
			return new ResponseEntity(productNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> Delete(@PathVariable int id)
	{
		try {
			serv.deleteProduct(serv.getProductById(id));
			return ResponseEntity.ok("Deleted Successfully!");
		} catch(ProductNotFoundException productNotFoundException) {
			return new ResponseEntity(productNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query){
		return ResponseEntity.ok(serv.searchProducts(query));
	}

}