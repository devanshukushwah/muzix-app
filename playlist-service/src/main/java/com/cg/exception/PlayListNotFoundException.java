package com.cg.exception;

public class PlayListNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6383346027195918405L;

	public PlayListNotFoundException(String message){
		super(message);
	}
	public PlayListNotFoundException(){
		super("PlayList not exist");
	}
}
