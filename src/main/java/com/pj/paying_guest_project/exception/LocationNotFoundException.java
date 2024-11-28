package com.pj.paying_guest_project.exception;

public class LocationNotFoundException extends RuntimeException{

	private String message = "Location Not Found";

	@Override
	public String getMessage() {
		return message;
	}

	public LocationNotFoundException(String message) {
		super();
		this.message = message;
	}

	public LocationNotFoundException() {
		super();
	}
}
