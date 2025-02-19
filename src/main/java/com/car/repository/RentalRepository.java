package com.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.model.Car;
import com.car.model.Person;
import com.car.model.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long>{
	
	Rental findRentalByPerson(Person person);
	
	List<Rental> findRentalsByPerson(Person person);
	List<Rental> findByPersonAndCarIn(Person person, List<Car> cars);


}
