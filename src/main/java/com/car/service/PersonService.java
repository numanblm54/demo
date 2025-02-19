package com.car.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dto.UserMailDTO;
import com.car.model.Person;
import com.car.repository.PersonRepository;

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
	
	 
	 public List<UserMailDTO> getAllMails() {
		 List<Person> persons = personRepository.findAll();
		 
		 /*
		  * 
		 below is with stream, but here used foreach, two example only to learn
		 
		 List<UserMailDTO> userMailDTOs = new ArrayList<>(); 
		 for(Person person : persons) {
			 UserMailDTO dto = new UserMailDTO(person.getFirstName(), person.getLastName(), person.getEmail());
			 userMailDTOs.add(dto);
		 }
		 
		 return userMailDTOs
		  */
	     return persons.stream()
				    .map(person -> new UserMailDTO(person.getFirstName(), person.getLastName(), person.getEmail()))
				    .collect(Collectors.toList());
	   }

}
