package com.sample.demo.jpa.exceptions;

public class ResourceNotFoundException extends Exception{
	public  static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
