package com.autoplant.emp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.autoplant.emp.dto.Error;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Error> handle(EmployeeException ex){
		ex.printStackTrace();
		if(ex instanceof NotFoundException) {
			return new ResponseEntity<Error>(new Error(ex.getMessage(),404),HttpStatus.NOT_FOUND);
		}
		if(ex instanceof BadException) {
			return new ResponseEntity<Error>(new Error(ex.getMessage(),400),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Error>(new Error("Failed",500),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
