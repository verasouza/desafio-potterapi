package com.hogwarts.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hogwarts.api.entity.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
	
	@Query("SELECT p FROM Personagem p WHERE LOWER (p.name) LIKE :name")
	List<Personagem> findByName(String name);
	
	

}
