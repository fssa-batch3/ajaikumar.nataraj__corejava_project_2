package com.fssa.rishi.validation.exceptions;

public class InvalidUserException extends Exception {

	private static final long serialVersionUID = -7798283981195321951L;

	public InvalidUserException(String msg) {
		super(msg);
	}

	public InvalidUserException(Throwable e) {
		super(e);
	}  
}
 