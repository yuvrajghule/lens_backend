package com.examly.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="OrderItems")
public class OrderItems {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String OrderItemsId;
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "order_Id")
	private OrderModel order;
	private String ProductName;
	private int quantity;
	private String Price;
	public OrderItems() {	
	}
	public OrderItems(String OrderItemsId, OrderModel order, String ProductName, int quantity, String Price) {
		this.OrderItemsId = OrderItemsId;
		this.order = order;
		this.ProductName = ProductName;
		this.quantity = quantity;
		this.Price = Price;
	}
	public String getOrderItemsId() {
		return OrderItemsId;
	}
	public void setOrderItemsId(String orderItemsId) {
		OrderItemsId = orderItemsId;
	}
	public OrderModel getOrder() {
		return order;
	}
	public void setOrder(OrderModel order) {
		this.order = order;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}

}