package com.revature.bank.exceptions;

public class NoSQLUpdatesException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2724131829166108463L;
	public NoSQLUpdatesException() {
        super();
    }
    public NoSQLUpdatesException(String message) {
        super(message);
    }
    public NoSQLUpdatesException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoSQLUpdatesException(Throwable cause) {
        super(cause);
    }

}
