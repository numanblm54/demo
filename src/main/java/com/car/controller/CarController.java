package com.car.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.car.dto.CarColor;
import com.car.model.Car;
import com.car.service.CarService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    // Get all cars
    @GetMapping("/all")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    // Get a car by ID
    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    // Get a car by ID
    @GetMapping("/id")
    public Optional<Car> getCarParamById(@RequestParam Long id) {
        return carService.getCarById(id);
    } 
   
    // Create a new car
    @PostMapping("/create-car")
    public Car createCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    // Update an existing car
    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        car.setId(id);
        return carService.saveCar(car);
    }

    // Delete a car by ID
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    // Get all cars
    @GetMapping("/price")
    public List<Car> getCarsByPrice(@RequestParam BigDecimal price) {
    	return carService.getCarByPriceGreaterThanEqual(price);
    }
    
    // Get all cars
    @GetMapping("/color")
    public List<Car> getCarsByColor(@RequestBody CarColor carColor) {
    	return carService.getCarByColor(carColor.getColor());
    }
    
    
}
