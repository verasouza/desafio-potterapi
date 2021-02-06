package com.hogwarts.api.model;

import com.hogwarts.api.entity.Personagens;


public interface PersonagemMapper {

	Personagens toModel(PersonagemModel dto);
	
	PersonagemModel toDto(Personagens model);
	
	
}
