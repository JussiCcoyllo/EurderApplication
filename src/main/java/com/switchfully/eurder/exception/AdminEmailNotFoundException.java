package com.switchfully.eurder.exception;

public class AdminEmailNotFoundException extends RuntimeException {

    public AdminEmailNotFoundException(){
        super("Admin Email not Founded");
    }

}
