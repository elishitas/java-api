package com.academia.app.rest.Controller;

import com.academia.app.rest.model.domain.StudentDTO;
import com.academia.app.rest.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }
    @PostMapping
    public ResponseEntity<StudentDTO> add(@RequestBody StudentDTO studentDTO){
        return ResponseEntity.ok(studentService.add(studentDTO));
    }
}

