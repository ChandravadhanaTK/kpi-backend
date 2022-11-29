package com.kpi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIRequestExceptionHandler {
	
	@ExceptionHandler(value= {RequestNotFoundException.class})
	public ResponseEntity<Object> handleAPIRequestNotFoundException(RequestNotFoundException ex){
		return handleException(HttpStatus.NOT_FOUND, ex.getMessage(), "Required Details Not found in the database.");
	}
	
	@ExceptionHandler(value= {RequestInvalidException.class})
	public ResponseEntity<Object> handleAPIRequestInvalidException(RequestInvalidException ex){
		return handleException(HttpStatus.BAD_REQUEST, ex.getMessage(), "Request is invalid. Please check the request once again.");
	}
	
	public ResponseEntity<Object> handleException(HttpStatus httpStatus, String customMessage, String generalMessage){
		String message = customMessage != null && !customMessage.isBlank()?customMessage : generalMessage;
		return ResponseEntity.status(httpStatus).body(message); 
	}
}
