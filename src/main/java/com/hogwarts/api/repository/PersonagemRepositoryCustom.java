package com.hogwarts.api.repository;

import java.util.List;

import com.hogwarts.api.entity.Personagem;

public interface PersonagemRepositoryCustom {
	
	List<Personagem> findByName(String name);

}
