package com.car.person_service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.model.Person;
import com.car.person_repository.PersonRepository;

@Service
public class PersonService {
	
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person savePerson(Person person) {
        return personRepository.save(person);
        }
	
	public List<Person> getAllPersons() {
        return  personRepository.findAll();
        }
	
	 public Optional<Person> getPersonById(Long id) {
	        return personRepository.findById(id);
	    }
	 
	 public void deletePerson(Long id) {
	        personRepository.deleteById(id);
	    }

}
