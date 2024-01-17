package com.webatrio.project.webapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

@Entity
public class Job {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private final Long id = null;

    private String nomEntreprise;
    private String poste;

    @ManyToOne
    @JoinColumn(name = "personne_id")
    private Person personne;

	private Date dateDebut;

	private Date dateFin;


    // Getters et setters
	public Long getId() {
		return id;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public Person getPersonne() {
		return personne;
	}

	public void setPersonne(Person personne) {
		this.personne = personne;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
		
	}

    
}