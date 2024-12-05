package com.car.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.car.model.Car;
import com.car.repository.CarRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Create or Update a car
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    // Get all cars
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // Get car by id
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    // Delete car by id
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
    
    public List<Car> getCarByPriceGreaterThanEqual(final BigDecimal price) {
    	return carRepository.getCarByPriceGreaterThanEqual(price);
    }
    
    public List<Car> getCarByColor(final String color) {
    	return carRepository.getCarByColor(color);
    }
      
}
