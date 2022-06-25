package com.example.backend.controller;

import java.lang.System.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.Classe;
import com.example.backend.model.Etudiant;
import com.example.backend.repository.ClasseRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ClasseController {

	@Autowired
	private ClasseRepository classerepo;
	
	//retourner la liste des classes
	@GetMapping("/classes")
	public List<Classe> getAllClasses(){
		return classerepo.findAll();
	}
	
	//ajouter classe
	@PostMapping("/add_classe")
	public Classe AddClasse(@RequestBody Classe classe) {
		return classerepo.save(classe);
	}
	
	//retourner classe by id
	@GetMapping("/classes/{id}")
	public ResponseEntity<Classe> GetClasseById(@PathVariable int id) {
		Classe classe = classerepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("La classe"+ id +" n'existe pas"));
		return ResponseEntity.ok(classe);
	}
		
	//modifier une classe 
	@PutMapping("/classes/{id}")
	public ResponseEntity<Classe> ModifierClasse(@PathVariable int id, @RequestBody Classe clas){
		Classe classe = classerepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("La classe"+ id +" n'existe pas"));
		
		classe.setClasseName(clas.getClasseName());
		
		Classe classe_modifiable = classerepo.save(classe);
		return ResponseEntity.ok(classe_modifiable);
	}
	
	//Supprimer classes
	@DeleteMapping("classes/{id}")
	public ResponseEntity<Map<String, Boolean>> SupprimerClasse(@PathVariable int id){
		Classe classe = classerepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("La classe"+ id +" n'existe pas"));
		
		classerepo.delete(classe);
		Map<String, Boolean> reponse = new HashMap<>();
		reponse.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(reponse);
	}


	
	
}
