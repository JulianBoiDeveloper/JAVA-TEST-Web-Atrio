package com.webatrio.project.webapp.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webatrio.project.webapp.entity.Job;
import com.webatrio.project.webapp.entity.Person;
import com.webatrio.project.webapp.repository.JobRepository;
import com.webatrio.project.webapp.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    @Qualifier("personRepository")
    private PersonRepository personRepository;
    
    @Autowired
    @Qualifier("jobRepository")
    private JobRepository jobRepository;

    public Person savePersonne(Person personne) throws Exception {
        if (isAgeValid(personne.getDateDeNaissance())) {
            return personRepository.save(personne);
        } else {
            throw new Exception("La personne doit avoir moins de 150 ans.");
        }
    }

    private boolean isAgeValid(Date dateDeNaissance) {
        Calendar dateLimite = Calendar.getInstance();
        dateLimite.add(Calendar.YEAR, -150);

        return dateDeNaissance.after(dateLimite.getTime());
    }
    public List<Person> getPeopleByCompanyName(String companyName) {
        List<Job> jobs = jobRepository.findByNomEntreprise(companyName);
        List<Person> people = jobs.stream()
                .map(Job::getPersonne)
                .collect(Collectors.toList());
        return people;
    }
    public Person getPersonById(Long id) {
        return personRepository.findById(id)
            .orElse(null); 
    }
}