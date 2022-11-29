package com.sample.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.demo.jpa.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{

	public Orders findTopByOrderByIdDesc();
}
