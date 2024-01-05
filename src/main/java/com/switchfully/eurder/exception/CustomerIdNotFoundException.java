package com.switchfully.eurder.exception;

public class CustomerIdNotFoundException extends RuntimeException {
    public CustomerIdNotFoundException() {
        super(" Customer id not founded");
    }
}
