package com.hogwarts.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hogwarts.api.entity.Personagem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonagemModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String role;
	private String school;
	private String house;
	private String patronus;

	
	public PersonagemModel (Personagem personagem) {
		this.name = personagem.getName();
		this.house = personagem.getHouse();
		this.patronus = personagem.getPatronus();
		this.role = personagem.getRole();
		this.school = personagem.getSchool();
	}
	

}
