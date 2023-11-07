package com.products.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.products.service.entities.Product;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product p WHERE p.Id LIKE CONCAT('%',:query,'%')"+
			" Or p.Name LIKE CONCAT('%',:query,'%')"+
			" Or p.Price LIKE CONCAT('%',:query,'%')"+
			" Or p.Category LIKE CONCAT('%',:query,'%')")
	List<Product> searchProductsSQL(String query);
	
}
