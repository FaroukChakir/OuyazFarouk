package com.example.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "Resultats")
public class Resultat {
	
	public Resultat() {}
	
	public Resultat(String nomClasse, String cne, String nomEtudiant, String prenomEtudiant, float note1, float note2,
			float note3, float note4, float note5, float note6) {
		super();
		NomClasse = nomClasse;
		this.cne = cne;
		NomEtudiant = nomEtudiant;
		PrenomEtudiant = prenomEtudiant;
		this.note1 = note1;
		this.note2 = note2;
		this.note3 = note3;
		this.note4 = note4;
		this.note5 = note5;
		this.note6 = note6;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom_classe")
	private String NomClasse;
	
	@Column(name = "cne_etudiant")
	private String cne;
	
	@Column(name = "nom_etudiant")
	private String NomEtudiant;
	
	@Column(name = "prenom_etudiant")
	private String PrenomEtudiant;
	
	@Column(name = "note_1")
	private float note1;
	
	@Column(name = "note_2")
	private float note2;
	
	@Column(name = "note_3")
	private float note3;
	
	@Column(name = "note_4")
	private float note4;
	
	@Column(name = "note_5")
	private float note5;
	
	@Column(name = "note_6")
	private float note6;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNomEtudiant() {
		return NomEtudiant;
	}

	public void setNomEtudiant(String nomEtudiant) {
		NomEtudiant = nomEtudiant;
	}

	public float getNote1() {
		return note1;
	}

	public void setNote1(float note1) {
		this.note1 = note1;
	}

	public float getNote2() {
		return note2;
	}

	public void setNote2(float note2) {
		this.note2 = note2;
	}

	public float getNote3() {
		return note3;
	}

	public void setNote3(float note3) {
		this.note3 = note3;
	}

	public float getNote4() {
		return note4;
	}

	public void setNote4(float note4) {
		this.note4 = note4;
	}

	public float getNote5() {
		return note5;
	}

	public void setNote5(float note5) {
		this.note5 = note5;
	}

	public float getNote6() {
		return note6;
	}

	public void setNote6(float note6) {
		this.note6 = note6;
	}

	public String getNomClasse() {
		return NomClasse;
	}

	public void setNomClasse(String nomClasse) {
		NomClasse = nomClasse;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getPrenomEtudiant() {
		return PrenomEtudiant;
	}



	public void setPrenomEtudiant(String prenomEtudiant) {
		PrenomEtudiant = prenomEtudiant;
	}
	

}
