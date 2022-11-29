package com.sample.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.sample.jpa.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer>{

	
}
