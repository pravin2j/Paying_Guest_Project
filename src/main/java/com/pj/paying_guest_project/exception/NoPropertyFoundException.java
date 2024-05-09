package com.pj.paying_guest_project.exception;

public class NoPropertyFoundException extends RuntimeException {

	private String message = "No Property Found";

	public String getMessage() {
		return message;
	}

	public NoPropertyFoundException(String message) {
		super();
		this.message = message;
	}

	public NoPropertyFoundException() {
		super();
	}

}
