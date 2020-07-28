package com.hogwarts.api.model;

import com.hogwarts.api.entity.Personagem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PersonagemModel {
	
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
