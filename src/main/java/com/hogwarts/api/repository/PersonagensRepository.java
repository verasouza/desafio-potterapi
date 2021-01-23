package com.hogwarts.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hogwarts.api.entity.Personagens;

@Repository
public interface PersonagensRepository extends MongoRepository<Personagens, String>, PersonagensRepositoryCustom {

}
