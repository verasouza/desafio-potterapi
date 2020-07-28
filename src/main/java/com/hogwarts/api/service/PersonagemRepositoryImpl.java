package com.hogwarts.api.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hogwarts.api.entity.Personagem;
import com.hogwarts.api.repository.PersonagemRepositoryCustom;

@Repository
public class PersonagemRepositoryImpl implements PersonagemRepositoryCustom {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Personagem> findByName(String name) {
		Query query = entityManager.createQuery("SELECT p FROM Personagem p WHERE LOWER (p.name) LIKE :nome",
				Personagem.class);
		query.setParameter("nome", "%" + name + "%");
		
		List<Personagem> resultado = query.getResultList();
		return resultado;
	}

}