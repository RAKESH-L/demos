package com.sample.demo.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookid")
	private int bookId;
	
	@Column(name="title", nullable = false)
	private String title;
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@Column(name = "authorid", nullable = false)
	private int authorId;
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(String title, double price, int authorId) {
		super();
		this.title = title;
		this.price = price;
		this.authorId = authorId;
	}
	public Books(int bookId, String title, double price, int authorId) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.authorId = authorId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", title=" + title + ", price=" + price + ", authorId=" + authorId + "]";
	}
	
	
}
