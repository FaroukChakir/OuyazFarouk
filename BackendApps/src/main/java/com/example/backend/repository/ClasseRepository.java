package com.example.backend.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.model.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Integer>{

}
