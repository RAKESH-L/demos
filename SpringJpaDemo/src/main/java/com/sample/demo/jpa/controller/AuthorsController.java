package com.sample.demo.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.sample.demo.jpa.entity.Authors;
import com.sample.demo.jpa.repository.AuthorsRepository;


@RestController
@RequestMapping("/api")
public class AuthorsController {
	
	@Autowired
	private AuthorsRepository repo;
	
	@GetMapping("/authors")
	public List<Authors> listAllAuthors() throws Exception{
		List<Authors> authors = repo.findAll();
		if(authors.size() == 0) {
			throw new Exception("Author table is empty");
		}
		return authors;
	}
	
	@PostMapping("/authors/insert")
	public Authors insertAuthors(@RequestBody Authors authors) {
		return repo.save(authors);
		
	}
	
	@PostMapping("/authors/in")
	public ResponseEntity<String> saveAuthorDetails(@RequestBody Authors author){
		String str = "Unable to upload author details";
		Authors a = repo.save(author);
		if(a!=null) {
			str = "Author details uploaded successfully";
		}
		return new ResponseEntity<String>(str, HttpStatus.OK);
		
	}
	
	@GetMapping("/authors/{id}")
//	 public ResponseEntity<Authors> getAuthorDetails(@PathVariable("id") int id){
//	 Authors author = repo.findById(id).get();
//	 if(author == null) {
//		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	 }
//	 return new ResponseEntity<>(author, HttpStatus.OK);
//	 }
	
	public Optional<Authors> getAuthorDetails(@PathVariable("id") int  id) throws Exception {
		Optional<Authors> authour = repo.findById(id);
		
		if(authour.isEmpty()) {
			throw new Exception("Author not found");
		}
		return authour;
	}
	@GetMapping("/author/email/{email}")
	public Optional<Authors> getAuthorByEmail(@PathVariable("email") String email) throws Exception{
		Optional<Authors> author = repo.findByEmail(email);
		
		if(author.isEmpty()) {
			throw new Exception("Author not found");
		}
		return author;
		
	}
	
	@Transactional
	@PutMapping("/author/update/{email}/{id}")
	public ResponseEntity<String> updateAuthorEmail(@PathVariable("id") int id, @PathVariable("email") String email){
		String str = "unable to update Author Email";
		
		int res = repo.updateEmail(id, email);
		if(res > 0) {
			str = "Author email updated";
		}
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@DeleteMapping("/author/delete/{id}")
	public ResponseEntity<String> deleteAuthorDetails(@PathVariable("id") int id){
		String str = "Unable to Delete";
		
		Authors a = repo.findById(id).get();
		
		if(a != null) {
			repo.deleteById(id);
			str = "Author with id:" + id + "deleted";
		}
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
}
