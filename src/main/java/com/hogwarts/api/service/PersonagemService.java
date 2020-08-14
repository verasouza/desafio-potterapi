package com.hogwarts.api.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
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
	@Value("${key}")
	private String apiKey;
	
	private static final String SORTINGHAT = "sortingHat";
	private static final String CHARACTERS = "characters";
	
	private RestTemplate template = new RestTemplate();
	
	
	public List<Personagem> findByNameDescription(String name){
		return personagemImpl.findByName(name);
	}
	
	public List<Personagem> findAll(){
		return personagemRepo.findAll();
	}
	
	public List<Personagem> findByHouse(String house){
		return personagemImpl.findByHouse(house);
	}
	
	public List<Personagem> findBySchool(String school){
		return personagemImpl.findBySchool(school);
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
		String house = template.getForObject(urlSorting, String.class);
		house = house.replaceAll("\"", "");
		return house;
		
	}
	
	public List<Personagem> getAllCharacatersFromHogwarts() {
		StringBuilder url = new StringBuilder("");
		url.append(apiurl);
		url.append(CHARACTERS);
		url.append("/?key=");
		url.append(apiKey);

		String dadosPersonagens = template.getForObject(url.toString(), String.class);
		Gson gson = new GsonBuilder().create();

		// encontra o tipo correto da classe
		Type tipoListaPersonagem = new TypeToken<ArrayList<Personagem>>() {
		}.getType();
		List<Personagem> personagens = gson.fromJson(dadosPersonagens, tipoListaPersonagem);
		
		//salvar os personagens da api no banco
		personagens.forEach(p ->{
			personagemRepo.save(p);
		});

		return personagens;

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
