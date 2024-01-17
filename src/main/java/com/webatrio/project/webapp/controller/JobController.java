package com.webatrio.project.webapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.webatrio.project.webapp.entity.Job;
import com.webatrio.project.webapp.entity.Person;
import com.webatrio.project.webapp.entity.dto.JobDTO;
import com.webatrio.project.webapp.services.JobService;
import com.webatrio.project.webapp.services.PersonService;

@RestController
@RequestMapping("/jobs")
public class JobController {
	
	@Autowired 
    private JobService jobService;
	
    @Autowired
    private PersonService personService;

    // Endpoints pour gérer les personnes
    
    @PostMapping("/add")
    public ResponseEntity<?> addEmploi(@RequestBody JobDTO jobDTO) {
        try {
            Job job = jobService.addJob(jobDTO);
            return ResponseEntity.ok(job);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/by-person-and-date-range")
    public List<Job> getJobsByPersonAndDateRange(
        @RequestParam Long personneId,
        @RequestParam Date startDate1,
        @RequestParam Date endDate1,
        @RequestParam Date startDate2,
        @RequestParam Date endDate2) {
        Person personne = personService.getPersonById(personneId);
        if (personne == null) {
            return null;
        }
        List<Job> jobs = jobService.getJobsByPersonAndDateRange(personne, startDate1, endDate1, startDate2, endDate2);
        return jobs;
    }
}