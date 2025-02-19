package com.car.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.car.dto.UserMailDTO;
import com.car.model.Person;
import com.car.service.PersonService;



@RestController
@RequestMapping("/api/persons")

public class PersonController {
	@Autowired
    private PersonService personService;
	
	 @GetMapping("/all")
	 public List<Person> getAllPersons() {
	     return personService.getAllPersons();
	     }
	 
	 @GetMapping("/{id}")
	 public Optional<Person> getPersonById(@PathVariable Long id) {
	     return personService.getPersonById(id);
	    }
	 
	 @GetMapping("/id")
	 public Optional<Person> getPersonParamById(@RequestParam Long id) {
	     return personService.getPersonById(id);
	  } 
	 
	 @PostMapping("/create-person")
	 public Person createPerson(@RequestBody Person person) {
	     return personService.savePerson(person);
	  }
	    
	    @PutMapping("/{id}")
	  public Person updateperson(@PathVariable Long id, @RequestBody Person person) {
	      person.setId(id);
	      return personService.savePerson(person);
	   }
	    
	    @DeleteMapping("/{id}")
	  public void deletePerson(@PathVariable Long id) {
	      personService.deletePerson(id);
	   }
	    
	 @GetMapping("/allMail")
	  public List<UserMailDTO> getAllMails() {
		 return personService.getAllMails();
	 }

}
