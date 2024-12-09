package com.car.rental_controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.model.Rental;
import com.car.rental_service.RentalService;



@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @Autowired
    private RentalService rentalService;

    // Kiralama oluştur
    @PostMapping("/create-rental")
    public Rental createRental(@RequestBody Rental rental) {
        return rentalService.createRental(rental);
    }

    // ID ile kiralamayı getir
    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable long id) {
        return rentalService.getRentalById(id);
    }

    // Kiralamayı sil
    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable long id) {
        rentalService.deleteRental(id);
    }

    // Kiralamayı güncelle
    @PutMapping("/{id}")
    public Rental updateRental(@PathVariable long id, @RequestBody Rental rentalDetails) {
        return rentalService.updateRental(id, rentalDetails);
    }



}
