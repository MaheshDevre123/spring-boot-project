package com.fourserveglobal.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fourserveglobal.exception.ErrorDetails;

@ControllerAdvice
public class PostExceptionController {
	@ExceptionHandler(value = ErrorDetails.class)
	public ResponseEntity<?> handleResourceNotFoundException(ErrorDetails exception , 
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), 
				request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}
}
