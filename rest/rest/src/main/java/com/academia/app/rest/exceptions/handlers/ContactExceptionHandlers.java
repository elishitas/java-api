package com.academia.app.rest.exceptions.handlers;

import com.academia.app.rest.exceptions.dtos.ContactErrorMessageDTO;
import com.academia.app.rest.exceptions.exceptionskind.ContactNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ContactExceptionHandlers {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<ContactErrorMessageDTO> defaultErrorHandler(HttpServletRequest req, Exception e){
        return new ResponseEntity<>(new ContactErrorMessageDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ContactNotFoundException.class)
    @ResponseBody
    public  ResponseEntity<ContactErrorMessageDTO> notFoundExceptionHandler(HttpServletRequest req, Exception e){
        return new ResponseEntity<>(new ContactErrorMessageDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
