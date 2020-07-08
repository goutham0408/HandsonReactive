package com.bezkoder.spring.data.cassandra.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.data.cassandra.exception.NoteNotFoundException;
import com.bezkoder.spring.data.cassandra.model.Notestable;
import com.bezkoder.spring.data.cassandra.repository.NotesLibRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/noteslib")
public class NotesLibController {

  @Autowired
  NotesLibRepository notesLibRepository;

  @GetMapping("/all")
  public ResponseEntity<List<Notestable>> getAllNotes() {
    try {
      List<Notestable> notes = new ArrayList<>();

      notes.add(new Notestable("SpringBoot", "pratice", getDate(), getDate(), false));
        notesLibRepository.findAll().forEach(notes::add);
      
      if (notes.isEmpty()) {
        return new ResponseEntity<>(notes,HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(notes, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/note/{name}")
  public ResponseEntity<Notestable> getTutorialByName(@PathVariable("name") String name) {
    Optional<Notestable> tutorialData = notesLibRepository.findByNotename(name);

    if (tutorialData.isPresent()) {
      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
    } else {
     // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	throw new NoteNotFoundException("The Note Book you are searching is not found");
    }
  }

  @PostMapping(value="/note",consumes= {"application/json"},produces= {"application/json"})
  public ResponseEntity<Notestable> createNote(@RequestBody Notestable note) {
    try {
    	Notestable saveNote = notesLibRepository.save(new Notestable(note.getNotename(),note.getNote(),getDate(),getDate(), false));
      return new ResponseEntity<>(saveNote, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    }
  }

  @PutMapping("/note/{name}")
  public ResponseEntity<Notestable> updateTutorial(@PathVariable("name") String id, @RequestBody Notestable tutorial) {
    Optional<Notestable> tutorialData = notesLibRepository.findByNotename(id);

    if (tutorialData.isPresent()) {
    	Notestable editNote = tutorialData.get();
    	editNote.setNotename(tutorial.getNotename());
    	editNote.setNote(tutorial.getNote());
    	editNote.setCreatedate(tutorial.getCreatedate());
    	editNote.setUpdatedate(getDate());
    	editNote.setDeleted(false);
      return new ResponseEntity<>(notesLibRepository.save(editNote), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/note/{name}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("name") String notename) {
    try {
      notesLibRepository.deleteByNotename(notename);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
  }

  public String getDate() {
	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
	   LocalDateTime now = LocalDateTime.now(); 
	   return dtf.format(now);
  }
}
