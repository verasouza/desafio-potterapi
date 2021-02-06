package com.hogwarts.api.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.hogwarts.api.entity.Personagens;
import com.hogwarts.api.service.PersonagemFilter;

@Repository
public class PersonagensRepositoryCustomImpl implements PersonagensRepositoryCustom {

	@Autowired
	private MongoTemplate mongoTemplate;

	
	@Override
	public List<Personagens> findByName(String name) {
		Query query = new Query();

		query.addCriteria(Criteria.where("name").is(name));
		return mongoTemplate.find(query, Personagens.class);
	}

	@Override
	public List<Personagens> filter(PersonagemFilter filter) {
		Query query = new Query();

		final List<Criteria> criteria = new ArrayList<>();

		if (filter.getName() != null && !filter.getName().isEmpty()) {
			criteria.add(Criteria.where("name").regex(filter.getName(), "i"));
		}

		if (filter.getHouse() != null && !filter.getHouse().isEmpty()) {
			criteria.add(Criteria.where("house").regex(filter.getHouse(), "i"));
		}

		if (filter.getSchool() != null && !filter.getSchool().isEmpty()) {
			criteria.add(Criteria.where("school").regex(filter.getSchool(), "i"));
		}

		if (!criteria.isEmpty()) {
			query.addCriteria(new Criteria().orOperator(criteria.toArray(new Criteria[criteria.size()])));
		}

		return mongoTemplate.find(query, Personagens.class);

	}

	/*
	 * @Override public List<PersonagemModel> filters(PersonagemFilter filter) {
	 * Query query = new Query();
	 * 
	 * final List<Criteria> criteria = new ArrayList<>();
	 * 
	 * if (filter.getName() != null && !filter.getName().isEmpty()) {
	 * criteria.add(Criteria.where("name").regex(filter.getName(), "i")); }
	 * 
	 * if (filter.getHouse() != null && !filter.getHouse().isEmpty()) {
	 * criteria.add(Criteria.where("house").regex(filter.getHouse(), "i")); }
	 * 
	 * if (filter.getSchool() != null && !filter.getSchool().isEmpty()) {
	 * criteria.add(Criteria.where("school").regex(filter.getSchool(), "i")); }
	 * 
	 * if (!criteria.isEmpty()) { query.addCriteria(new
	 * Criteria().orOperator(criteria.toArray(new Criteria[criteria.size()]))); }
	 * 
	 * List<Personagens> listaPersonagens = mongoTemplate.find(query,
	 * Personagens.class);
	 * 
	 * return listaPersonagens.stream().map(m ->
	 * mapper.toDto(m)).collect(Collectors.toList()); }
	 */

}
