package com.autoplant.emp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.autoplant.emp.dto.Error;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Error> handle(Exception ex){
		return new ResponseEntity<Error>(new Error("Failed to add",500),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
