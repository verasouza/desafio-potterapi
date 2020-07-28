package com.hogwarts.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hogwarts.api.entity.Personagem;
import com.hogwarts.api.model.PersonagemModel;
import com.hogwarts.api.repository.PersonagemRepository;

import exceptions.ResourceNotFoundException;

@Service
public class PersonagemService {
	
	@Autowired
	private PersonagemRepository personagemRepo;
	@Autowired
	private PersonagemRepositoryImpl personagemImpl;
	
	@Value("${apiurl}")
	private String apiurl;
	private static final String SORTINGHAT = "sortingHat";
	
	private RestTemplate template = new RestTemplate();
	
	public List<Personagem> findByName(String name){
		return personagemRepo.findByName(name);
	}
	
	public List<Personagem> findByNameDescription(String name){
		return personagemImpl.findByName(name);
	}
	
	public List<Personagem> findAll(){
		return personagemRepo.findAll();
	}
	
	public Personagem findById(Long id) {
		return personagemRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Personagem não encontrado"));

	}
	
	public Personagem createPersonagem(PersonagemModel personagemModel) {
		Personagem novoPersonagem = new Personagem();
		
		personagemDTO(personagemModel, novoPersonagem);
		
		novoPersonagem.setHouse(sortingHat());
		
		personagemRepo.save(novoPersonagem);
		
		return novoPersonagem;
		
	}
	
	public Personagem updatePersonagem (Long id, PersonagemModel personagemModel) {
		Personagem personagem = this.findById(id);
		personagemDTO(personagemModel, personagem);
		personagemRepo.saveAndFlush(personagem);
		return personagem;
	}
	
	private void personagemDTO(PersonagemModel personagemModel, Personagem personagem) {

		personagem.setName(personagemModel.getName());
		personagem.setRole(personagemModel.getRole());
		personagem.setPatronus(personagemModel.getPatronus());
		personagem.setSchool(personagemModel.getSchool());
		
		
	}
	
	public void deletePersonagem(Long id) {

		Personagem personagem = this.findById(id);
		personagemRepo.delete(personagem);

	}
	
	public String sortingHat() {
		String urlSorting = apiurl + SORTINGHAT;
		return template.getForObject(urlSorting, String.class);
		
	}
	
	public List<PersonagemModel> getListaPersonagens(List<Personagem> personagens){
		List<PersonagemModel> listaPersonagens = new ArrayList<>();
		
		personagens.forEach(p ->{
			PersonagemModel personagem = new PersonagemModel(p);
			listaPersonagens.add(personagem);
		});
		
		return listaPersonagens;
	}

}
