package com.car.rental_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.model.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
	
	
}


