package com.spring.Example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Example.model.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer>{

}
