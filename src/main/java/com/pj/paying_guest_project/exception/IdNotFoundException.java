package com.pj.paying_guest_project.exception;

public class IdNotFoundException extends RuntimeException{

	private String message = "Id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundException() {
		super();
	}
	
	
	
	
}
