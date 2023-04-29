package com.bezkoder.springjwt.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Groupe;
import com.bezkoder.springjwt.repository.GroupeRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GroupeController {
	@Autowired
	GroupeRepository groupeRepository;

	  @GetMapping("/groupes")
	  public ResponseEntity<List<Groupe>> getAllGroupes(@RequestParam(required = false) String name) {
		  try {
		      List<Groupe> groupes = new ArrayList<Groupe>();

		      if (name == null)
		    	  groupeRepository.findAll().forEach(groupes::add);
		      else
		    	  groupeRepository.findByNameContaining(name).forEach(groupes::add);

		      if (groupes.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(groupes, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }

	  @GetMapping("/groupes/{id}")
	  public ResponseEntity<Groupe> getGroupeById(@PathVariable("id") long id) {
		  Optional<Groupe> groupeData = groupeRepository.findById(id);

		    if (groupeData.isPresent()) {
		      return new ResponseEntity<>(groupeData.get(), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	  }

	  @PostMapping("/groupes")
	  public ResponseEntity<Groupe> createGroupe(@RequestBody Groupe groupe) {
		  try {
			  Groupe _groupe = groupeRepository.save(new Groupe(groupe.getName(), groupe.getAge_interval(), groupe.getNumber_kids(),groupe.getKids(),groupe.getActivities()));
		      return new ResponseEntity<>(_groupe, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }

	  @PutMapping("/groupes/{id}")
	  public ResponseEntity<Groupe> updateGroupe(@PathVariable("id") long id, @RequestBody Groupe groupe) {
		  Optional<Groupe> grouplData = groupeRepository.findById(id);

		    if (grouplData.isPresent()) {
		    	Groupe _groupe = grouplData.get();
		    	_groupe.setName(groupe.getName());
		    	_groupe.setAge_interval(groupe.getAge_interval());
		    	_groupe.setNumber_kids(groupe.getNumber_kids());
		      return new ResponseEntity<>(groupeRepository.save(_groupe), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	  }

	  @DeleteMapping("/groupes/{id}")
	  public ResponseEntity<HttpStatus> deleteGroupe(@PathVariable("id") long id) {
		  try {
			  groupeRepository.deleteById(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }

	  @DeleteMapping("/groupes")
	  public ResponseEntity<HttpStatus> deleteAllGroupes() {
		  try {
			  groupeRepository.deleteAll();
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	}
