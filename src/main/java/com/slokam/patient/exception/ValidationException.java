package com.slokam.patient.exception;

public class ValidationException extends Exception{
	
	public ValidationException() {
		
	}
	
	public ValidationException(String message) {
		super(message);      //the error msg we entered set through this to exception class then to throwable interface.
	}
	
	public ValidationException(String message, Throwable t) {
		super(message,t);
	}
}
