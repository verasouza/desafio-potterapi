package com.hogwarts.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hogwarts.api.service.PersonagemService;

@SpringBootTest
class HogwartsapiApplicationTests {

	@Autowired
	private PersonagemService service;
	
	@Test
	void consumerTest() {
		String casa = service.sortingHat();
		System.out.println(casa);
	}

}
