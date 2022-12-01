package com.academia.app.rest.exceptions.exceptionskind;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(String message){
        super(message);
    }
}
