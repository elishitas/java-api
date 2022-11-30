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
    private final ContactService contactService;
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<ContactDTO>> findTodos(){
        return ResponseEntity.ok(contactService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> findOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(contactService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MessageDTO> add(@RequestBody ContactDTO contactDTO){
        return ResponseEntity.ok(contactService.add(contactDTO));
    }
}
