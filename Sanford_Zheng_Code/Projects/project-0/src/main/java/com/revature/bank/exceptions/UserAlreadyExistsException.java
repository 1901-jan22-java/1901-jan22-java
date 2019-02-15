package com.revature.bank.exceptions;

public class UserAlreadyExistsException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4984840041658876977L;
	public UserAlreadyExistsException() {
        super();
    }
    public UserAlreadyExistsException(String message) {
        super(message);
    }
    public UserAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
    public UserAlreadyExistsException(Throwable cause) {
        super(cause);
    }

}
