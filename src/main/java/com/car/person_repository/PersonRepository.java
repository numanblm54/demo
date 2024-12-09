package com.car.person_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	
}
   

