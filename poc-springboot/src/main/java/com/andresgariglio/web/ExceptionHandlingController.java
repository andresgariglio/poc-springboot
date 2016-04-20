package com.andresgariglio.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		Map<String, String> messages = new HashMap<String, String>();
		for (ConstraintViolation<?> violation : violations) {
			messages.put(violation.getPropertyPath().toString(), violation.getMessage());
		}

		return ResponseEntity.badRequest().body(messages);
	}

}