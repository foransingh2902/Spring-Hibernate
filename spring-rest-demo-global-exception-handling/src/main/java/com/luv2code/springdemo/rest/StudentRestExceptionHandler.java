package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // will work as an AOP filter to pre or post process the request and response
public class StudentRestExceptionHandler {
	// add exception handling code here
	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler // this tells its an exception handler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe) {
		// Response entity is basically a wrapper around the response, so it provide a
		// fine grain control
		// over the response sent to the user
		// this method will only catch StudentNotFoundException as given in arguments

		// create a StudentErrorRespnse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exe.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	// add another exception handler.. to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exe) {
		// create a StudentErrorRespnse
		StudentErrorResponse error = new StudentErrorResponse();
		// 400 error- BAD_REQUEST
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exe.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
