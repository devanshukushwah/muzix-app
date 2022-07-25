package com.cg.exception;

public class PlayListAlreadyExistException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6383346027195918405L;

	public PlayListAlreadyExistException(String message){
		super(message);
	}
	
	public PlayListAlreadyExistException() {
		super("PlayList already exist");
	}
}
