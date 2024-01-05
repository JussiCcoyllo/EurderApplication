package com.switchfully.eurder.exception;

public class PasswordIsNotValidException extends RuntimeException {
    public PasswordIsNotValidException(){
        super("Password not valid");
    }
}
