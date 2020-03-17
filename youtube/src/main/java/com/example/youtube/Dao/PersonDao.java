package com.example.youtube.Dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.youtube.Models.Person;


public interface PersonDao {

	int insertPerson(UUID id, Person person); 
		
		
	default int insertPerson(Person person) {
			
	UUID id = UUID.randomUUID();
	
	return insertPerson( id, person);
			
		
	}
	
	public List<Person> selectAllPerson();
	
	Optional <Person> selectPersonById(UUID id);
	
	int deletePersonById(UUID id);		
	
	int updatePersonById(UUID id, Person person);
	
}
