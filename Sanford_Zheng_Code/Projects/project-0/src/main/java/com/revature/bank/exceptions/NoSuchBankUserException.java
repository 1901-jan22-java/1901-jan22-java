package com.revature.bank.exceptions;

public class NoSuchBankUserException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4322166170237900754L;
	public NoSuchBankUserException() {
        super();
    }
    public NoSuchBankUserException(String message) {
        super(message);
    }
    public NoSuchBankUserException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoSuchBankUserException(Throwable cause) {
        super(cause);
    }

}
