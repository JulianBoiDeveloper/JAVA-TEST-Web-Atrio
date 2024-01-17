package com.webatrio.project.webapp.entity.dto;

import java.util.Date;

public class JobDTO {
    private Long personneId;
    private String nomEntreprise;
    private String poste;
    private Date dateDebut;
    private Date dateFin;
    
	public Long getPersonneId() {
		return personneId;
	}
	public void setPersonneId(Long personneId) {
		this.personneId = personneId;
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
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

    // Getters et setters
    
}