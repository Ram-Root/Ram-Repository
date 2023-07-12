package com.slokam.patient.exceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.slokam.patient.entity.AppError;
import com.slokam.patient.exception.ValidationException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ApplicationExceptionHandler.class);
	
	

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<AppError> validationExceptionHandler(ValidationException ex){
		
		LOGGER.trace("Entered into validationExceptionHandler");
		
		AppError error = new AppError();
		error.setErrorcode(12301);
		error.setDescription(ex.getMessage());
		error.setException(ex);
		
		LOGGER.error("Error Object "+error);
		
		 ResponseEntity<AppError> re = ResponseEntity.badRequest().body(error);
		 LOGGER.trace("exit form validationExceptionHandler");
		 return re;
	}
}
