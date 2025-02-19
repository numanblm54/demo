package com.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.car.dto.RentalDTO;
import com.car.model.Rental;
import com.car.service.RentalService;


@RestController
@RequestMapping("api/rentals")

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
    
    @GetMapping("/rentalWithPath/{personID}")
    public List<RentalDTO> getRentalInformation(@PathVariable long personID) {
        return rentalService.getRentalInformation(String.valueOf(personID));
    } 
    
    @GetMapping("/withParam")
    public List<RentalDTO> getRentalInformations(@RequestParam long  personID) {
        return rentalService.getRentalInformation(String.valueOf(personID));
    }
    
    @GetMapping("/withParamCarAndPerson")
    public List<RentalDTO> getRentalInformations(@RequestParam long  personID, @RequestParam String carBrand) {
        return rentalService.getRentalInformations(String.valueOf(personID),carBrand);
    }

}
