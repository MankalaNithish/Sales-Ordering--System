package com.spring.Example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.Example.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query(value = "select * from customer not in(select customer_id from orders)",nativeQuery = true)
	public List<Customer> findAllIds();
}
