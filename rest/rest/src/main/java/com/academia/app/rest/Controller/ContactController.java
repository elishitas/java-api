package com.academia.app.rest.Controller;

import com.academia.app.rest.model.domain.ContactDTO;
import com.academia.app.rest.model.domain.MessageDTO;
import com.academia.app.rest.services.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contacService;

    public ContactController(ContactService contacService){
        this.contacService = contacService;
    }

    @GetMapping
    public ResponseEntity<List<ContactDTO>> findTodos(){
        return ResponseEntity.ok(contacService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> findOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(contacService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MessageDTO> add(@RequestBody ContactDTO contactDTO){
        return ResponseEntity.ok(contacService.add(contactDTO));
    }
}
