package com.revature.bank.exceptions;

public class NoSQLUpdatesException extends Exception {

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
