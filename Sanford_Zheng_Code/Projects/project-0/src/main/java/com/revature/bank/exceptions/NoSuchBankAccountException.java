package com.revature.bank.exceptions;

public class NoSuchBankAccountException extends Exception{

    public NoSuchBankAccountException() {
        super();
    }
    public NoSuchBankAccountException(String message) {
        super(message);
    }
    public NoSuchBankAccountException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoSuchBankAccountException(Throwable cause) {
        super(cause);
    }

}
