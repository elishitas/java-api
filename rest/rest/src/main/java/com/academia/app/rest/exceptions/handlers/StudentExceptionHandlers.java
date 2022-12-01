package com.academia.app.rest.exceptions.handlers;

import com.academia.app.rest.exceptions.dtos.StudentErrorMessageDTO;
import com.academia.app.rest.exceptions.exceptionskind.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class StudentExceptionHandlers {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<StudentErrorMessageDTO> defaultErrorHandler(HttpServletRequest req, Exception e){
        return new ResponseEntity<>(new StudentErrorMessageDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseBody
    public ResponseEntity<StudentErrorMessageDTO> notFoundExceptionHandler(HttpServletRequest req, Exception e){
        return new ResponseEntity<>(new StudentErrorMessageDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
