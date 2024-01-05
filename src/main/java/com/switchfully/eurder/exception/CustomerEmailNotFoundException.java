package com.switchfully.eurder.exception;

public class CustomerEmailNotFoundException extends RuntimeException{
    public CustomerEmailNotFoundException() {
        super("Customer email not founded");
    }
}
