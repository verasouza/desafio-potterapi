package com.hogwarts.api.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hogwarts.api.entity.Personagens;
import com.hogwarts.api.model.PersonagemModel;
import com.hogwarts.api.service.PersonagemFilter;
import com.hogwarts.api.service.PersonagensService;

import exceptions.ResourceNotFoundException;

@Controller
@RequestMapping(value = "characters")
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
public class PersonagensController {

	@Autowired
	private PersonagensService personagensService;

	@GetMapping(value = "/")
	public ResponseEntity<List<Personagens>> getAllPersonagens() {
		List<Personagens> personagens = personagensService.findAll();

		return ResponseEntity.ok().body(personagens);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Personagens> findPersonagemById(@PathVariable("id") String id) {
		Personagens personagens = personagensService.findById(id);

		return ResponseEntity.ok().body(personagens);
	}


	@PostMapping(value = "/save")
	public ResponseEntity<Personagens> save(@RequestBody Personagens personagem) {
		Personagens newPersonagem = personagensService.save(personagem);

		return ResponseEntity.ok().body(newPersonagem);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Personagens> update(@PathVariable("id") String id, @RequestBody Personagens personagem) {
		Personagens currentPersonagem = personagensService.update(id, personagem);

		return ResponseEntity.ok().body(currentPersonagem);
	}

	@PostMapping(value = "/filter")
	public ResponseEntity<List<Personagens>> filterPersonagens(@RequestBody PersonagemFilter filter) {
		List<Personagens> personagens = personagensService.filterPersonagens(filter);

		return ResponseEntity.ok().body(personagens);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		try {
			personagensService.delete(id);
			return new ResponseEntity<>(id, HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}
	
	/*
	 * @GetMapping(value = "/filters") public ResponseEntity<List<PersonagemModel>>
	 * filterCharacters(@RequestBody PersonagemFilter filter) {
	 * List<PersonagemModel> personagens = service.filterCharacters(filter);
	 * 
	 * return ResponseEntity.ok().body(personagens); }
	 */

}
