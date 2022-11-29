package com.sample.demo.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "authors")
public class Authors {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "authorid")
	private int authorId;
	
	@Column(name = "authorname")
	private String authorName;
	
	@Column(name = "email", unique = true)
	private String email;

	public Authors() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Authors(String authorName, String email) {
		super();
		this.authorName = authorName;
		this.email = email;
	}

	public Authors(int authorId, String authorName, String email) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.email = email;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Authors [authorId=" + authorId + ", authorName=" + authorName + ", email=" + email + "]";
	}

}
