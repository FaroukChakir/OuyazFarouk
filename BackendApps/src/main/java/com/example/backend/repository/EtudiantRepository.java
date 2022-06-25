package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{

}
