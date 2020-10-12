package com.spring.Example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.Example.model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer>{

	@Query(value="select product_id from products",nativeQuery = true)
	public List<Integer> findAllIds();
}
