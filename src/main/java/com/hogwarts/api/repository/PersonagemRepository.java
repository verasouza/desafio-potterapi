package com.hogwarts.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hogwarts.api.entity.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
	
	
	

}
