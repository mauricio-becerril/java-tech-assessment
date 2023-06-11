package com.maubece.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maubece.demo.models.PersonModel;
import com.maubece.demo.services.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService service;
    
    @GetMapping
    public List<PersonModel> getPersons() {
        return service.getPersons();
    }

    @PostMapping
    public PersonModel savePerson(@RequestBody PersonModel person) {
        return service.savePerson(person);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) {
        if (service.deletePerson(id)) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
