package com.car.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>  {
	
	public List<Car> getCarByPriceGreaterThanEqual(final BigDecimal price);
	
	public List<Car> getCarByColor(final String color);

}
