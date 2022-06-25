package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.model.Resultat;

public interface ResultatRepository extends JpaRepository<Resultat, Integer>{

	
}
