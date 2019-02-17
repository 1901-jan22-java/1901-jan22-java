package com.revature.bank.exceptions;

public class DuplicateAccountTypeException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3849810672718968190L;
	public DuplicateAccountTypeException() {
        super();
    }
    public DuplicateAccountTypeException(String message) {
        super(message);
    }
    public DuplicateAccountTypeException(String message, Throwable cause) {
        super(message, cause);
    }
    public DuplicateAccountTypeException(Throwable cause) {
        super(cause);
    }

}
