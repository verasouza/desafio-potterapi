package com.hogwarts.api.entity;

public enum Houses {
	
	GRYFFINDOR("Gryffindor"),
	RAVENCLAW("Ravenclaw"),
	SLYTHERIN("Slytherin"),
	HUFFLEPUFF("Hufflepuff");
	
	private String descricao;

	Houses(String descricao) {
		this.descricao = descricao;
	}
	
	

	public String getDescricao() {
		return descricao;
	}

	
	
}
