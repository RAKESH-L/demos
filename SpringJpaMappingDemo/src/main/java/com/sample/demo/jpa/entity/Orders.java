package com.sample.demo.jpa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "totalquantity")
	private int totalQuantity;
	
	@Column(name = "totalprice")
	private double totalPrice;
	
	@Column(name = "status")
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderid", referencedColumnName = "id" )
	private Set<Items> orderItems = new HashSet<>();


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getTotalQuantity() {
		return totalQuantity;
	}


	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Set<Items> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(Set<Items> orderItems) {
		this.orderItems = orderItems;
	}

	public void add(Items item) {
		if(item != null) {
			if(orderItems == null) {
				orderItems = new HashSet<>();
			}
		}
		orderItems.add(item);
	}
	
	
}
