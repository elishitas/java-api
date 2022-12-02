package com.academia.app.rest.exceptions.exceptionskind;

public class ContactFoundException extends RuntimeException{
    public ContactFoundException(String message){
        super(message);
    }
}
