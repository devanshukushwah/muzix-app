package com.cg.advice;

import java.util.HashMap;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.exception.SongAlreadyExistException;
import com.cg.exception.SongNotFoundException;

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
	@ExceptionHandler(SongNotFoundException.class)
	public Map<String,String> handleSongNotFoundException(SongNotFoundException ex) {
		Map<String,String> message = new HashMap<>();
		message.put("message",ex.getMessage());
		return message;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(SongAlreadyExistException.class)
	public Map<String,String> handleSongAlreadyExistException(SongAlreadyExistException ex) {
		Map<String,String> message = new HashMap<>();
		message.put("message",ex.getMessage());
		return message;
	}
	
	
}
