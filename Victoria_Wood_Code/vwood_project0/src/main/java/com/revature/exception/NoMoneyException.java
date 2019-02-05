package com.revature.exception;

public class NoMoneyException extends Exception {

	public NoMoneyException() {}

	public NoMoneyException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoMoneyException(String message) {
		super(message);
	}
	

}
