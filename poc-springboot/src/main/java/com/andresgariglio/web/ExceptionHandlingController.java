package com.andresgariglio.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingController {

	// Convert a predefined exception to an HTTP Status code
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Data integrity violation")
	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
	public void error() {
		// Nothing to do
	}
}