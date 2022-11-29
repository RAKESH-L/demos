package com.sample.demo.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.jpa.entity.Books;
import com.sample.demo.jpa.repository.BooksRepository;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class BooksController {

	@Autowired
	private BooksRepository bookRepo;
	
	@GetMapping("/books")
	public List<Books> listAllBooks() throws Exception{
		List<Books> books = bookRepo.findAll();
		if(books.size() == 0) {
			throw new Exception("Book table is empty");
		}
		return books;
		
	}
	
	@GetMapping("/book/{id}")
	public Optional<Books> getBooksDetails(@PathVariable("id") int id) throws Exception{
		Optional<Books> books = bookRepo.findById(id);
		
		if(books.isEmpty()) {
			throw new Exception("Book not found");
		}
		return books;
		
	}
	
	@PostMapping("/book/insert")
	public String insertBook(@RequestBody Books book) {
		String str = "Unable to upload Books";
		Books b = bookRepo.save(book);
		if(b != null) {
			str = "Book details uploaded";
		}
		return str;
	}
	@Transactional
	@PutMapping("/book/update/{price}/{id}")
	public String updateBookPrice(@PathVariable("id") int id, @PathVariable("price") double price) {
		String str = "unable to update book";
		
		int res = bookRepo.updateBookPrice(id, price);
		if(res > 0) {
			str = "book price updated";
		}
		return str;
	}
	
	@DeleteMapping("/book/delete/{id}")
	public String deleteBookDetails(@PathVariable("id") int id) {
		String str = "Unable to delete Book";
		
		Books b = bookRepo.findById(id).get();
		
		if(b != null) {
			bookRepo.deleteById(id);
			str = "Book with id: " + id + " deleted";
		}
		return str;
	}
//	@GetMapping("book/between/{min}/{max}")
//	public List<Books> findBooksBetween(@PathVariable("min") double min, @PathVariable("max") double max){
//		List<Books> books = bookRepo.findBookaBetween(min, max);
//
//		return books;
//		
//	}
}
