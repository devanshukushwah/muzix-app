package com.cg.exception;

public class UserAlreadyExistException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6933908149727944609L;

	public UserAlreadyExistException(String message){
		super(message);
	}
	
	public UserAlreadyExistException() {
		super("User already exist");
	}
}
