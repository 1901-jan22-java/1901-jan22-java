package com.revature.bank.exceptions;

public class NonPositiveAmountException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7796843148748595998L;
	public NonPositiveAmountException() {
        super();
    }
    public NonPositiveAmountException(String message) {
        super(message);
    }
    public NonPositiveAmountException(String message, Throwable cause) {
        super(message, cause);
    }
    public NonPositiveAmountException(Throwable cause) {
        super(cause);
    }

}
