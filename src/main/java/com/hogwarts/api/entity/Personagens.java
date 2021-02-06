package com.hogwarts.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection =  "personagens")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Personagens {
	
	@Id
	private String id;
	private String name;
	private String role;
	private String school;
	private String house;
	private String patronus;
	

	

}
