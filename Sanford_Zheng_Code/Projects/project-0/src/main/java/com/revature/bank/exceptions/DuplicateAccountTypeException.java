package com.revature.bank.exceptions;

public class DuplicateAccountTypeException extends Exception {

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
