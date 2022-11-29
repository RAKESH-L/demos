package com.sample.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.demo.jpa.entity.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long>{
	
	//select * from 
	public Items findTopByOrderByIdDesc();
}
