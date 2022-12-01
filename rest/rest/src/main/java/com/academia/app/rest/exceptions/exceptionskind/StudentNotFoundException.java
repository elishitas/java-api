package com.academia.app.rest.exceptions.exceptionskind;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message){
        super(message);
    }

}
