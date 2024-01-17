package com.webatrio.project.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.webatrio.project.webapp.entity.Person;
import com.webatrio.project.webapp.services.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    // Endpoints pour gérer les personnes
    
    @PostMapping
    public ResponseEntity<?> savePerson(@RequestBody Person person) {
        try {
            Person nouvellePerson = personService.savePersonne(person);
            return ResponseEntity.ok(nouvellePerson);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/by-company/{companyName}")
    public List<Person> getPeopleByCompany(@PathVariable String companyName) {
        List<Person> people = personService.getPeopleByCompanyName(companyName);
        return people;
    }
    
}