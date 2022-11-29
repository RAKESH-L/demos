package com.sample.demo.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sample.demo.jpa.entity.Items;
import com.sample.demo.jpa.entity.Orders;
import com.sample.demo.jpa.service.ItemService;
import com.sample.demo.jpa.service.OrderService;

@SpringBootApplication
public class SpringJpaMappingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaMappingDemoApplication.class, args);
//		ApplicationContext ctx = SpringApplication.run(SpringJpaMappingDemoApplication.class, args);
//		
//		ItemService service = ctx.getBean(ItemService.class);
//		OrderService orderService = ctx.getBean(OrderService.class);
//		
//		
//		Items i = new Items();
//		
//		i.setId(123);
//		i.setItemName("Pencil");
//		i.setPrice(199);
//		i.setQuantity(10);
//		Items item = service.addItemDetails(i);
//		
//		if(item != null) {
//			System.out.println("Item added successfully");
//			orderService.addToOrder(item);
//		} else {
//			System.out.println("Item not added");
//		}
//		
//		Orders o = new Orders();
//		
//		o.setId(123);
//		o.setTotalQuantity(65);
//		o.setTotalPrice(2000);
//		o.setStatus("Payment done");
//		Orders order = orderService.addOrderdetails(o);
//		
//		if(order != null) {
//			System.out.println("Order added ");
//		}else {
//			System.out.println("Order not added");
//		}
	}

}
