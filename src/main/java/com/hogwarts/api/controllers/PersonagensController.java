package com.hogwarts.api.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hogwarts.api.entity.Personagens;
import com.hogwarts.api.model.PersonagemModel;
import com.hogwarts.api.service.PersonagemFilter;
import com.hogwarts.api.service.PersonagensService;

@Controller
@RequestMapping(value = "characters")
public class PersonagensController {

	@Autowired
	private PersonagensService personagensService;

	@GetMapping(value = "/")
	public ResponseEntity<List<Personagens>> getAllPersonagens() {
		List<Personagens> personagens = personagensService.findAll();

		return ResponseEntity.ok().body(personagens);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Personagens> save(@RequestBody Personagens personagem) {
		Personagens newPersonagem = personagensService.save(personagem);

		return ResponseEntity.ok().body(newPersonagem);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Personagens> update(@PathParam("id") String id, @RequestBody Personagens personagem) {
		Personagens currentPersonagem = personagensService.update(id, personagem);

		return ResponseEntity.ok().body(currentPersonagem);
	}

	@GetMapping(value = "/filter")
	public ResponseEntity<List<Personagens>> filterPersonagens(@RequestBody PersonagemFilter filter) {
		List<Personagens> personagens = personagensService.filterPersonagens(filter);

		return ResponseEntity.ok().body(personagens);
	}
	
	/*
	 * @GetMapping(value = "/filters") public ResponseEntity<List<PersonagemModel>>
	 * filterCharacters(@RequestBody PersonagemFilter filter) {
	 * List<PersonagemModel> personagens = service.filterCharacters(filter);
	 * 
	 * return ResponseEntity.ok().body(personagens); }
	 */

}
