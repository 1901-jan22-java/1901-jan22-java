package com.revature.bank.exceptions;

public class UnableToAddAccountException extends Exception{

    public UnableToAddAccountException() {
        super();
    }
    public UnableToAddAccountException(String message) {
        super(message);
    }
    public UnableToAddAccountException(String message, Throwable cause) {
        super(message, cause);
    }
    public UnableToAddAccountException(Throwable cause) {
        super(cause);
    }

}
