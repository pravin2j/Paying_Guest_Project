package com.pj.paying_guest_project.exception;

public class EmailNotFoundException extends RuntimeException {

	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	public EmailNotFoundException(String message) {
		super();
		this.message = message;
	}

	public EmailNotFoundException() {
		super();
	}
	
	
	
	
}
