package com.example.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.example.backend.model.Resultat;
import com.example.backend.repository.ResultatRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ResultatController {
	
	@Autowired
	private ResultatRepository resultatrepo;
	
	//retourner la liste des résultats
	@GetMapping("/resultats")
	public List<Resultat> getAllResultats(){
		return resultatrepo.findAll();
	}
	
	//ajouter resultat
	@PostMapping("/add_resultat")
	public Resultat AddResultat(@RequestBody Resultat resultat) {
		return resultatrepo.save(resultat);
	}
	
	//retourner resultat by id
	@GetMapping("/resultats/{id}")
	public ResponseEntity<Resultat> GetResultatById(@PathVariable int id) {
		Resultat resultat = resultatrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Résultat"+ id +" n'existe pas"));
		return ResponseEntity.ok(resultat);
	}
	
	//modifier une résultat 
	@PutMapping("/resultats/{id}")
	public ResponseEntity<Resultat> ModifierResultat(@PathVariable int id, @RequestBody Resultat result){
		Resultat resultat = resultatrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Résultat"+ id +" n'existe pas"));
		
		resultat.setCne(result.getCne());
		resultat.setNomClasse(result.getNomClasse());
		resultat.setNote1(result.getNote1());
		resultat.setNote2(result.getNote2());
		resultat.setNote3(result.getNote3());
		resultat.setNote4(result.getNote4());
		resultat.setNote5(result.getNote5());
		resultat.setNote6(result.getNote6());
		
		Resultat resultat_modifiable = resultatrepo.save(resultat);
		return ResponseEntity.ok(resultat_modifiable);
	}
	
	//Supprimer resultats
	@DeleteMapping("resultats/{id}")
	public ResponseEntity<Map<String, Boolean>> SupprimerResultat(@PathVariable int id){
		Resultat resultat = resultatrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Résultat"+ id +" n'existe pas"));
		
		resultatrepo.delete(resultat);
		Map<String, Boolean> reponse = new HashMap<>();
		reponse.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(reponse);
	}
}
