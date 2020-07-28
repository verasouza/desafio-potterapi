package com.hogwarts.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HouseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("_id")
	private String id;
	@JsonProperty("name")
	private String casa;

}
