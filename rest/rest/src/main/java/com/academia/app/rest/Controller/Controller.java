package com.academia.app.rest.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class Controller {

    @GetMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntity.status(HttpStatus.OK).body("Hola, mi nombre es Maria Elisa y me dices Lis") ;
    }

    @PostMapping("/goodbye")
    public ResponseEntity goodbye(){
        return ResponseEntity.status(HttpStatus.OK).body("Hasta luego");
    }


}

