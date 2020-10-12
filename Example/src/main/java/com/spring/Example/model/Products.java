package com.spring.Example.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_seq")
	@SequenceGenerator(name = "product_seq",allocationSize = 1,initialValue = 1001)
	private Integer productId;
	
	private String productName;
	private float productPrice;
	
	@OneToMany(mappedBy = "primaryKey.products")
	private Set<OrderItems> orderItems = new HashSet<>();
	
	public Set<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
}
