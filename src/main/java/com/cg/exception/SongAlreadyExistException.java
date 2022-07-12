package com.cg.exception;

public class SongAlreadyExistException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6383346027195918405L;

	public SongAlreadyExistException(String message){
		super(message);
	}
	
	public SongAlreadyExistException() {
		super("Song already exist");
	}
}
