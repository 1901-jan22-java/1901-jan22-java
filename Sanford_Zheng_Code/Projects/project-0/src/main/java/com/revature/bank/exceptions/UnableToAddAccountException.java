package com.revature.bank.exceptions;

/**
 * There were better descriptors. Deprecated is not meant to be used this way but
 * I was going to delete it. Just see if we can eventually use, re-purpose or throw
 * away for good.
 * 
 * @deprecated
 * 
 * @author Sanford
 *
 */
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
