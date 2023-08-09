package io.bankmanagment.retail.base.exception;

public class NotFoundException extends Exception{
    public NotFoundException() {
        super("requested resource not found");
    }
}
