package com.spring.Example.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
@AssociationOverrides({
	@AssociationOverride(name = "primaryKey.products",joinColumns = @JoinColumn(name = "product_id")),
	@AssociationOverride(name = "primaryKey.orders",joinColumns = @JoinColumn(name = "order_id"))
})
public class OrderItems {

	@EmbeddedId
	private OrderItemsId primaryKey;
	
	//additional columns
	private float itemPrice;
	private String itemName;
	private Integer quantity;
	
	public Orders getOrders() {
		return getPrimaryKey().getOrders();
	}
	public void setOrders(Orders orders) {
		getPrimaryKey().setOrders(orders);
	}
	public Products getProducts() {
		return getPrimaryKey().getProducts();
	}
	public void setProducts(Products products) {
		getPrimaryKey().setProducts(products);
	}
	public OrderItemsId getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(OrderItemsId primaryKey) {
		this.primaryKey = primaryKey;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
