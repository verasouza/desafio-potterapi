package com.hogwarts.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hogwarts.api.entity.Personagem;
import com.hogwarts.api.model.PersonagemModel;
import com.hogwarts.api.service.PersonagemService;

@RestController
@RequestMapping(value="/personagem")
public class PersonagemController {
	
	@Autowired
	private PersonagemService service;
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<Personagem> cadastrarPersonagem(@RequestBody PersonagemModel personagemModel){
		Personagem novoPersonagem = service.createPersonagem(personagemModel);
		
		return new ResponseEntity<>(novoPersonagem, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/procurar")
	public List<PersonagemModel> getPersonagemByName(@RequestParam("nome") String name){
		List<Personagem> personagens = service.findByNameDescription(name);
		
		return service.getListaPersonagens(personagens);
		
	}
	
	@GetMapping(value="/listarcadastrados")
	public List<PersonagemModel> getAllPersonagensCadastrados(){
		List<Personagem> personagens = service.findAll();
		
		return service.getListaPersonagens(personagens);
		
	}
	
	@GetMapping(value="/listarpersonagens")
	public ResponseEntity<List<Personagem>> getAllPersonagens(){
		List<Personagem> personagens = service.getAllCharacatersFromHogwarts();
		
		return ResponseEntity.ok().body(personagens);
		
	}
	
	@GetMapping(value="/procurarporcasa")
	public List<PersonagemModel> getPersonagemByHouse(@RequestParam("house") String house){
		List<Personagem> personagens = service.findByHouse(house);
		
		return service.getListaPersonagens(personagens);
		
	}
	
	@GetMapping(value="/procurarporescola")
	public List<PersonagemModel> getPersonagemBySchool(@RequestParam("school") String school){
		List<Personagem> personagens = service.findBySchool(school);
		
		return service.getListaPersonagens(personagens);
		
	}

}
