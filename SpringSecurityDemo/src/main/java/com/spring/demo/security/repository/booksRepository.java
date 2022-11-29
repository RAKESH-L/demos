package com.spring.demo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.security.entity.Books;

@Repository
public interface booksRepository extends JpaRepository<Books, Integer>{

}
