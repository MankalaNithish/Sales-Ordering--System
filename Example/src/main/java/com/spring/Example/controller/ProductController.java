package com.spring.Example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Example.model.Products;
import com.spring.Example.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping(value = "/insertProduct")
	public String insertProduct(@RequestBody Products product) {
		productRepository.save(product);
		return "Product Saved";
	}
}
