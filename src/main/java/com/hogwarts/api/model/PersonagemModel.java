package com.hogwarts.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonagemModel {

	private String name;
	private String role;
	private String school;
	private String house;
	private String patronus;

}
