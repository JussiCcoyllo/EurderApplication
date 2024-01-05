package com.switchfully.eurder.exception;

public class AdminIdNotFoundException extends RuntimeException {

    public AdminIdNotFoundException(){
        super("Admin Id not Founded");
    }
}
