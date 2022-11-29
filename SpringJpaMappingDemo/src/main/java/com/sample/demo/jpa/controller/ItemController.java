package com.sample.demo.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.jpa.entity.Items;
import com.sample.demo.jpa.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemController {

	@Autowired
	private ItemService service;
	
	@GetMapping("/items")
	public List<Items> listAllItems(){
		return service.listAllItems();
	}
	
	@GetMapping("/items/{id}")
	public ResponseEntity<Items> getItemDetails(@PathVariable("id") long id){
		Items item = null;
		try {
			item = service.getItemsDetailsById(id);
		} catch (Exception e) {
			return new ResponseEntity<Items>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Items>(item, HttpStatus.OK);
	}
	
	@PostMapping("/items/insert")
	public String insertItems(@RequestBody Items items) {
		String str = "Unable to upload Items";
		Items i = service.addItemDetails(items);
		if(i != null) {
			str = "Items Uploaded";
		}
		return str;
	}
}
