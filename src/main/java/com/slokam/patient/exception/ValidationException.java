package com.slokam.patient.exception;

public class ValidationException extends Exception{
	
	public ValidationException() {
		
	}
	
	public ValidationException(String message) {
		super(message);
	}
	
	public ValidationException(String message, Throwable t) {
		super(message,t);
	}
}
