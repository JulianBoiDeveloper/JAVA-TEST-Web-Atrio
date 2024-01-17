package com.webatrio.project.webapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.webatrio.project.webapp.entity.Job;
import com.webatrio.project.webapp.entity.Person;


public interface JobRepository extends JpaRepository<Job, Long>{
	 List<Job> findByNomEntreprise(String nomEntreprise);
	 List<Job> findByPersonneAndDateDebutBetweenAndDateFinBetween(
		        Person personne, Date startDate1, Date endDate1, Date startDate2, Date endDate2);
}
