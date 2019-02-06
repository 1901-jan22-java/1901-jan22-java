package com.revature.bank.exceptions;

public class NonPositiveAmountException extends Exception {

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
