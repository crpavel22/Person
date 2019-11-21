package com.pavel.test.Person.controller;

import com.pavel.test.Person.entity.Person;
import com.pavel.test.Person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;
    @PostMapping(path = "/api/person")
    public ResponseEntity<Person> register(@RequestBody Person p) {
        return ResponseEntity.ok(personService.save(p));
    }
    @GetMapping(path = "/api/person")
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(personService.getAll());
    }
    @GetMapping(path = "/api/person/{person-id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(name="person-id", required=true)Long personId) {
        Person person = personService.findById(personId);
        if (person != null) {
            return ResponseEntity.ok(person);
        }
        return ResponseEntity.notFound().build();
    }
}
