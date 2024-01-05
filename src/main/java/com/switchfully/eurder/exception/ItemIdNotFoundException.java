package com.switchfully.eurder.exception;

public class ItemIdNotFoundException extends RuntimeException{
    public ItemIdNotFoundException(){
        super("Item Id not Founded");
    }

}
