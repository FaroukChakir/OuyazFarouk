package com.example.backend.controller;

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
import com.example.backend.model.Etudiant;

import com.example.backend.repository.EtudiantRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EtudiantController {

	@Autowired
	private EtudiantRepository etudiantrepo;
	
	//retourner la liste des étudiants
	@GetMapping("/etudiants")
	public List<Etudiant> getAllEtudiants(){
		return etudiantrepo.findAll();
	}
	
	//ajouter etudiant
	@PostMapping("/add_etudiant")
	public Etudiant AddEtudiant(@RequestBody Etudiant etudiant) {
		return etudiantrepo.save(etudiant);
	}
	
	//retourner etudiant by id
	@GetMapping("/etudiants/{id}")
	public ResponseEntity<Etudiant> GetEtudiantById(@PathVariable int id) {
		Etudiant etudiant = etudiantrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("L'étudiant"+ id +" n'existe pas"));
		return ResponseEntity.ok(etudiant);
	}
	
	//modifier un étudiant 
	@PutMapping("/etudiants/{id}")
	public ResponseEntity<Etudiant> ModifierEtudiant(@PathVariable int id, @RequestBody Etudiant etud){
		Etudiant etudiant = etudiantrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("L'étudiant"+ id +" n'existe pas"));
		
		etudiant.setCne(etud.getCne());
		etudiant.setNom(etud.getNom());
		etudiant.setPrenom(etud.getPrenom());
		etudiant.setAdresse(etud.getAdresse());
		etudiant.setEmail(etud.getEmail());
		etudiant.setClasse(etud.getClasse());
		etudiant.setGroupe(etud.getGroupe());
		
		Etudiant etudiant_modifiable = etudiantrepo.save(etudiant);
		return ResponseEntity.ok(etudiant_modifiable);
	}
	
	//Supprimer etudiants
	@DeleteMapping("etudiants/{id}")
	public ResponseEntity<Map<String, Boolean>> SupprimerEtudiant(@PathVariable int id){
		Etudiant etudiant = etudiantrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("L'étudiant"+ id +" n'existe pas"));
		
		etudiantrepo.delete(etudiant);
		Map<String, Boolean> reponse = new HashMap<>();
		reponse.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(reponse);
	}
	
}
