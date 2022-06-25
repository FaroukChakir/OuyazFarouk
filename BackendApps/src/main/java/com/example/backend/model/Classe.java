package com.example.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Classe {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom_classe", nullable = false)
	private String classeName;

	
	public Classe() {}
	
	public Classe(Integer id, String classeName) {
		this.classeName = classeName;
		this.id=id;
	}

	public Integer getId() {
		return id;
	}
	
	public String getClasseName() {
		return classeName;
	}

	public void setClasseName(String classeName) {
		this.classeName = classeName;
	}
	
	
}
