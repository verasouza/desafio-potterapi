package com.hogwarts.api.repository;

import java.util.List;

import com.hogwarts.api.entity.Personagens;
import com.hogwarts.api.service.PersonagemFilter;

public interface PersonagensRepositoryCustom {

	List<Personagens> findByName(String name);

	List<Personagens> filter(PersonagemFilter filter);
	
	//List<PersonagemModel> filters(PersonagemFilter filter);

}
