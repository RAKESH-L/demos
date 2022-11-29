package com.sample.demo.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.jpa.entity.Items;
import com.sample.demo.jpa.exceptions.ResourceNotFoundException;
import com.sample.demo.jpa.repository.ItemsRepository;

@Service
public class ItemService {

	@Autowired
	private ItemsRepository repo;
	
	public List<Items>  listAllItems(){
		List<Items> items = repo.findAll();
		return items;
	}
	
	public Items getItemsDetailsById(long id) throws ResourceNotFoundException {
		Items item = repo.findById(id).get();
		
		if(item == null) {
			throw new ResourceNotFoundException("Item with id" + id + "not found");
		}
		return item;
	}
	public Items addItemDetails(Items item) {
		Items item1 = repo.findTopByOrderByIdDesc();
		
		long id = 1L;
		if(item1 != null) {
			id = item1.getId() + 1;
		}
		item.setId(id);
		
		item1 = repo.save(item);
		
		return item1;
	}
}
