package com.example.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "Etudiants")
public class Etudiant {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name = "cne_etudiant", unique = true, nullable = false)
	private String cne;
	
	@Column(name = "nom_etudiant")
	private String nom;
	
	@Column(name = "prenom_etudiant")
	private String prenom;
	
	@Column(name = "adresse_etudiant")
	private String adresse;
	
	@Column(name = "email_etudiant")
	private String email;
	
	@Column(name = "classe_etudiant")
	private String classe;
	
	@Column(name = "groupe_etudiant")
	private String groupe;
	
	public Etudiant() {
		
	}
	public Etudiant(String cne, String nom, String prenom, String adresse, String email, String classe, String groupe) {
		
		this.cne = cne;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.classe = classe;
		this.groupe = groupe;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	
	
}
