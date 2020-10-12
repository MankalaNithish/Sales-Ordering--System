package com.spring.Example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.Example.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	@Query(value = "select customer_id from orders where product_id=?",nativeQuery = true)
	public List<Integer> task2(Integer id);
	
	@Query(value = "select product_id from orders",nativeQuery = true)
	public List<Integer> findAllProductIds();
	
	@Query(value = "select customer_id from orders",nativeQuery = true)
	public List<Integer> findAllCustomerIds();
}
