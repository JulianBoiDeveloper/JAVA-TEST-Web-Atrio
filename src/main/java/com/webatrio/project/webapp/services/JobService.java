package com.webatrio.project.webapp.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webatrio.project.webapp.entity.Job;
import com.webatrio.project.webapp.entity.Person;
import com.webatrio.project.webapp.entity.dto.JobDTO;
import com.webatrio.project.webapp.repository.JobRepository;
import com.webatrio.project.webapp.repository.PersonRepository;

@Service
public class JobService {
	
    @Autowired
    @Qualifier("jobRepository")
    private JobRepository jobRepository;
    
    @Autowired
    @Qualifier("personRepository")
    private PersonRepository personRepository;

    // Méthodes pour gérer les emplois
    public Job addJob(JobDTO jobDTO) throws Exception {
        Person person = personRepository.findById(jobDTO.getPersonneId())
                .orElseThrow(() -> new Exception("Personne non trouvée"));

        Job job = new Job();
        job.setPersonne(person);
        job.setNomEntreprise(jobDTO.getNomEntreprise());
        job.setPoste(jobDTO.getPoste());
        job.setDateDebut(jobDTO.getDateDebut());
        job.setDateFin(jobDTO.getDateFin());

        return jobRepository.save(job);
    }

    public List<Job> getJobsByPersonAndDateRange(Person personne, Date startDate1, Date endDate1, Date startDate2, Date endDate2) {
        return jobRepository.findByPersonneAndDateDebutBetweenAndDateFinBetween(
            personne, startDate1, endDate1, startDate2, endDate2);
    }

}





