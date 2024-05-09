package com.pj.paying_guest_project.exception;

public class TypeNotFoundException extends RuntimeException{

	private String message = "Type Not Found";

	@Override
	public String getMessage() {
		return message;
	}

	public TypeNotFoundException(String message) {
		super();
		this.message = message;
	}

	public TypeNotFoundException() {
		super();
	}

	
}
