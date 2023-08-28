package com.fssa.rishi.validation.exceptions;

public class InvalidProductException extends Exception{
	
	private static final long serialVersionUID = -1194860954774008955L;

	public InvalidProductException(String msg) {
		super(msg);
	}

	public InvalidProductException(Throwable e) {
		super(e);
	} 

}
 