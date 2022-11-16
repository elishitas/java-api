package com.academia.app.rest.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String hello() {
        return "Hola, mi nombre es Elis" ;
    }

    @PostMapping("/goodbye")
    public String goodbye(){
        return "Hasta luego";
    }

    @PostMapping("/goodbyer")
    public ResponseEntity goodbyer(){
        return ResponseEntity.status(HttpStatus.OK).body("Adios desde el response entity");
    }
}

