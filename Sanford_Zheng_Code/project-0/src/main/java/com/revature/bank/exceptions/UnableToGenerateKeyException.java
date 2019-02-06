package com.revature.bank.exceptions;

public class UnableToGenerateKeyException extends Exception {

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
