package com.example.youtube.Models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	private final UUID id;
	private final String name;
	public int  nom;
	
	
	public Person(@JsonProperty ("id") UUID id,
				@JsonProperty("name") String name) {
	this.id=id;
	this.name=name;
	
	
}
	public UUID getId() {
		return id;
	}


	public String getName() {
		return name;
	}
}
