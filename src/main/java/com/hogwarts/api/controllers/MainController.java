package com.hogwarts.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hogwarts.api.entity.Personagem;
import com.hogwarts.api.service.PersonagemService;

@Controller
public class MainController {
	
	@Autowired
	private PersonagemService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/consultar")
	public String consultar(Model model) {
			List<Personagem> personagens = service.getAllCharacatersFromHogwarts();
			model.addAttribute("listapersonagens", personagens);
			
			return "consultar";
			
		
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "cadastrar";
	}

}
