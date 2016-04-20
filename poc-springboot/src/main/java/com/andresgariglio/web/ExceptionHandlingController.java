package com.andresgariglio.web;

import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException e) {
		Map<String, String> messages = e.getConstraintViolations().stream().collect(
				Collectors.toMap(violation -> violation.getPropertyPath().toString(), ConstraintViolation::getMessage));

		return ResponseEntity.badRequest().body(messages);
	}

}