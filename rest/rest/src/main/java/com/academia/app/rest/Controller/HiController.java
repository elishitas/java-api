package com.academia.app.rest.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class HiController {

    @GetMapping("/hellogreeting")
    public ResponseEntity hellogreeting(){
        return ResponseEntity.status(HttpStatus.OK).body("Hola, mi nombre es Maria Elisa y me llaman Lis, cambie el nombre del controller") ;
    }

    @PostMapping("/goodbyegreeting")
    public ResponseEntity goodbyegreeting() {
        return ResponseEntity.status(HttpStatus.OK).body("Hasta luego! Ya no cambio más el nombre del controller");
    }
}
