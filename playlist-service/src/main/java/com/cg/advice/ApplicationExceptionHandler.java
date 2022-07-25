package com.cg.advice;

import java.util.HashMap;


import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.exception.PlayListAlreadyExistException;
import com.cg.exception.PlayListNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex) {
		Map<String,String> message = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(err->message.put(err.getField(), err.getDefaultMessage()));
		return message;
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(PlayListNotFoundException.class)
	public Map<String,String> handlePlayListNotFoundException(PlayListNotFoundException ex) {
		Map<String,String> message = new HashMap<>();
		message.put("message",ex.getMessage());
		return message;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(PlayListAlreadyExistException.class)
	public Map<String,String> handlePlayListAlreadyExistException(PlayListAlreadyExistException ex) {
		Map<String,String> message = new HashMap<>();
		message.put("message",ex.getMessage());
		return message;
	}
	
	
}
