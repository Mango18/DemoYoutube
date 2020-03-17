package com.example.youtube.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.youtube.Models.Person;



@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{
	
	private static List<Person> DB = new ArrayList<>();
	
	@Override
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		
		DB.add(new Person(id, person.getName()));
		
		
		
		return 1;
		
	}

	@Override
	public List<Person> selectAllPerson() {
		// TODO Auto-generated method stub
		return DB;
	}

	
	@Override
	public Optional<Person> selectPersonById(UUID id) {
		
		
		
		return DB.stream()
				.filter(person -> person.getId().equals(id))
				.findFirst();
	}
	
/////_----------------------------------------------------------------------------------AQUI EL problema


	@Override
	public int deletePersonById(UUID id) {
		Optional <Person> personMaybe=  selectPersonById(id);
		
		// if(person.isEmpty) en vez de "isPresent
		
		if (personMaybe.isPresent() ) {
			
			return 0;
			
		}
		DB.remove(personMaybe.get());
		
		return 1;
	}

	@Override
	public int updatePersonById(UUID id, Person person) {
		
		return selectPersonById(id)
				.map(Person -> {
					int indexPersonToDelete= DB.indexOf(person);
					if (indexPersonToDelete>=0) {
						DB.set(indexPersonToDelete, person);
						return 1;
						
					}
					return 0;
					
				})
				.orElse(0);
	}
	


	
	
	
}
