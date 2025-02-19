package com.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	Person findPersonByFirstNameAndLastName(String firstName,String lastName);
	
	Person findPersonByPersonID(String personID);
	
	

}
