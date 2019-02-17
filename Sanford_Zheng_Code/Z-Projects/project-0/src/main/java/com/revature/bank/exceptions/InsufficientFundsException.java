package com.revature.bank.exceptions;

public class InsufficientFundsException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4208000402297495468L;
	public InsufficientFundsException() {
        super();
    }
    public InsufficientFundsException(String message) {
        super(message);
    }
    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }
    public InsufficientFundsException(Throwable cause) {
        super(cause);
    }

}
