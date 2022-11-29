package com.spring.demo.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.security.entity.Books;
import com.spring.demo.security.repository.booksRepository;

@RestController
@RequestMapping("/api")
@Validated
public class BooksController {

	@Autowired
	private booksRepository booksRepository;
	
	@GetMapping("/books")
	public List<Books> listAll(){
		return booksRepository.findAll();
	}
	
	@GetMapping("/books/{id}")
	public Books retrieveOne(@PathVariable("id") int id) {
		return booksRepository.findById(id).get();
	}
	
	@PostMapping("/books")
	public Books addNewBook( @RequestBody Books book) {
		return booksRepository.save(book);
	}
}
