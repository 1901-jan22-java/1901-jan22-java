package com.revature.bank.exceptions;

public class NoSuchBankUserException extends Exception {

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
