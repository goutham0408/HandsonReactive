package com.bezkoder.spring.data.cassandra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.data.cassandra.exception.NoteNotFoundException;

@RestController
@RequestMapping("/note")
public class NoteController {
	
    @GetMapping("/{id}")
    public String getCustomer(@PathVariable String id) {
        if (id.contains("1")) {
            return "Java";
        } else if (id.contains("2")) {
            return "Spring";
        } else if (id.contains("3")) {
            return "Cassandra";
        } else {
           throw new NoteNotFoundException("Note Book not found.");
        }
    }

}
