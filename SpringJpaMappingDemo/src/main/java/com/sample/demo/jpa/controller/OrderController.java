package com.sample.demo.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.jpa.entity.Orders;
import com.sample.demo.jpa.exceptions.ResourceNotFoundException;
import com.sample.demo.jpa.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order/insert")
	public String insertOrder(@RequestBody Orders order) {
		String str = "Unable to upload orders";
		Orders o = orderService.addOrderdetails(order);
		if(o != null) {
			str = "Orders Uploaded";
		}
		return str;
	}
	
	@GetMapping("/orders")
	public List<Orders> listAllOrders(){
		return orderService.listAllOrders();
	}
	
	@GetMapping("/order/{id}")
	public Orders getOrderById(@PathVariable("id") long id) throws ResourceNotFoundException {
		return orderService.getOrderDetailsById(id);
	}
}
