package com.sample.demo.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.jpa.entity.Items;
import com.sample.demo.jpa.entity.Orders;
import com.sample.demo.jpa.exceptions.ResourceNotFoundException;
import com.sample.demo.jpa.repository.OrdersRepository;

@Service
public class OrderService {

	@Autowired
	private OrdersRepository ordersRepository;
	
	public Orders addOrderdetails(Orders order) {
		Orders order1 = ordersRepository.findTopByOrderByIdDesc();
		
		long id = 1L;
		if(order1 != null) {
			id = order1.getId();
		}
		order.setId(id);
		order1 = ordersRepository.save(order);
		
		return order1;
	}
	
	public List<Orders> listAllOrders() {
		List<Orders> order = ordersRepository.findAll();
		return order;
	}
	
	public Orders getOrderDetailsById(long id) throws ResourceNotFoundException{
		Orders order = ordersRepository.findById(id).get();
		
		if(order == null) {
			throw new ResourceNotFoundException("Item with id " +id+ "not found");
			
		}
		return order;
	}
	
	public void addToOrder(Items item) {
		Orders order = new Orders();
		
		order.add(item);
	}
}
