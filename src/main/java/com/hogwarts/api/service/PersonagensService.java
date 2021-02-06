package com.hogwarts.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hogwarts.api.entity.Personagens;
import com.hogwarts.api.model.PersonagemModel;
import com.hogwarts.api.repository.PersonagensRepository;

import exceptions.ResourceNotFoundException;

@Service
public class PersonagensService {

	@Autowired
	private PersonagensRepository personagensRepository;

	public Personagens findById(String id) {
		return personagensRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Personagem não encontrado"));
	}

	public List<Personagens> findAll() {
		return personagensRepository.findAll();
	}

	public Personagens save(Personagens personagem) {
		return personagensRepository.save(personagem);
	}
	
	public void delete(String id) {
		Personagens personagem = findById(id);
		personagensRepository.delete(personagem);
	}

	public Personagens update(String id, Personagens request) {
		Personagens personagem = findById(id);

		personagem.setHouse(request.getHouse());
		personagem.setName(request.getName());
		personagem.setPatronus(request.getPatronus());
		personagem.setRole(request.getRole());

		personagensRepository.save(personagem);

		return personagem;

	}

	public List<Personagens> filterPersonagens(PersonagemFilter filter) {
		return personagensRepository.filter(filter);
	}
	
	/*
	 * public List<PersonagemModel> filterCharacters(PersonagemFilter filter){
	 * return personRepo.filters(filter); }
	 */

}
