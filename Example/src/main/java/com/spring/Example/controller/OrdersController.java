package com.spring.Example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Example.model.Customer;
import com.spring.Example.model.OrderItems;
import com.spring.Example.model.Orders;
import com.spring.Example.repository.CustomerRepository;
import com.spring.Example.repository.OrderItemsRepository;
import com.spring.Example.repository.OrdersRepository;
import com.spring.Example.repository.ProductRepository;

@RestController
public class OrdersController {

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemsRepository orderItemsRepository;
	
	@PostMapping("/insertOrder")
	public String insert(@RequestBody Orders orders) {
		Orders ord = ordersRepository.save(orders);
		Set<OrderItems> itemList = orders.getOrderItems();
		itemList.forEach(item->{item.getPrimaryKey().setOrders(ord);
								orderItemsRepository.save(item);
								});
		System.out.println(ord.getOrderId());
		itemList.forEach(item->System.out.println(item.getPrimaryKey().getOrders()));
		return "Order Received";
	}
	
	@GetMapping("/task2/{productId}")
	public List<Integer> task2(@PathVariable Integer productId) {
		List<Integer> ids = ordersRepository.task2(productId);
		return ids;
	}
	
	@GetMapping("/task1")
	public List<Integer> task1(){
		List<Integer> a = productRepository.findAllIds();
		List<Integer> b = ordersRepository.findAllProductIds();
		List<Integer> c = new ArrayList<>(a);
		c.removeAll(b);
		return c;
	}
	
	@GetMapping("/task3")
	public List<Customer> task3(){
		List<Customer> a = customerRepository.findAllIds();
		return a;
	}
}