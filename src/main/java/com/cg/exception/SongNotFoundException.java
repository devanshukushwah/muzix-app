package com.cg.exception;

public class SongNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6383346027195918405L;

	public SongNotFoundException(String message){
		super(message);
	}
	public SongNotFoundException(){
		super("song not exist");
	}
}
