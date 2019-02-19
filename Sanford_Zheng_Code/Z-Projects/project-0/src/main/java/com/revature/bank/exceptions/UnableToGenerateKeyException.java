package com.revature.bank.exceptions;

public class UnableToGenerateKeyException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7148595128874689195L;
	public UnableToGenerateKeyException() {
        super();
    }
    public UnableToGenerateKeyException(String message) {
        super(message);
    }
    public UnableToGenerateKeyException(String message, Throwable cause) {
        super(message, cause);
    }
    public UnableToGenerateKeyException(Throwable cause) {
        super(cause);
    }

}
