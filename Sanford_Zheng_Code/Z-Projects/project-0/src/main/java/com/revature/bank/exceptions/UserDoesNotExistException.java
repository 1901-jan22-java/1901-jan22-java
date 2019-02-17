package com.revature.bank.exceptions;

public class UserDoesNotExistException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8802872199745823558L;
	public UserDoesNotExistException() {
        super();
    }
    public UserDoesNotExistException(String message) {
        super(message);
    }
    public UserDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
    public UserDoesNotExistException(Throwable cause) {
        super(cause);
    }

}
