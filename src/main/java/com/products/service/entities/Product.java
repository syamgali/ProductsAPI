package com.products.service.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int Id;
	
	@Column(nullable = false)
	private String Name;
	
	@Column(nullable = false)
	private double Price;
	
	@Column(nullable = false)
	private String Category;
	
}
