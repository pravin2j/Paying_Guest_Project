package com.pj.paying_guest_project.exception;

public class AvailabilityNotFoundException extends RuntimeException{

	private String message = "Availability Not Found";

	public String getMessage() {
		return message;
	}

	public AvailabilityNotFoundException(String message) {
		super();
		this.message = message;
	}

	public AvailabilityNotFoundException() {
		super();
	}
	
	
}
