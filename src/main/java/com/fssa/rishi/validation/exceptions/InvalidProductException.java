package com.fssa.rishi.validation.exceptions;

public class InvalidProductException extends Exception{
	
	private static final long serialVersionUID = -7798283981195321951L;

	public InvalidProductException(String msg) {
		super(msg);
	}

	public InvalidProductException(Throwable e) {
		super(e);
	} 

}
 