package io.bankmanagment.base.exception;

public class CustomMethodNotAllowedException extends RuntimeException  {
    public CustomMethodNotAllowedException(String message) {
        super(message);
    }

    public CustomMethodNotAllowedException() {
        super("Method not allowed");
    }
}
