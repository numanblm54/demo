package com.car.rental_service;

import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.model.Car;
import com.car.model.Person;
import com.car.model.Rental;
import com.car.person_repository.PersonRepository;
import com.car.rental_repository.RentalRepository;
import com.car.repository.CarRepository;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CarRepository carRepository;

    // Rental nesnesini oluşturur
    public Rental createRental(Rental rental) {
        // Başlangıç ve bitiş tarihleri arasındaki farkı hesapla
        long rentalDays = ChronoUnit.DAYS.between(rental.getRentalStartDate(), rental.getRentalEndDate());
        
        // Kiralama süresi 0 veya negatif olamaz
        if (rentalDays <= 0) {
            throw new IllegalArgumentException("Kiralama süresi geçersiz");
        }
        
        // RentalDays değerini güncelle
        rental.setRentalDays(rentalDays);

        // Person ve Car nesnelerini ID'lere göre bul
        Person person = personRepository.findById(rental.getPerson().getId())
            .orElseThrow(() -> new RuntimeException("Person not found"));
        
        Car car = carRepository.findById(rental.getCar().getId())
            .orElseThrow(() -> new RuntimeException("Car not found"));

        // Rental nesnesinin Person ve Car nesnelerini atama
        rental.setPerson(person);
        rental.setCar(car);

        // Kiralama nesnesini kaydet
        return rentalRepository.save(rental);
    }

    // Kiralamayı ID'ye göre getir
    public Rental getRentalById(long rentID) {
        return rentalRepository.findById(rentID)
            .orElseThrow(() -> new RuntimeException("Rental not found"));
    }

    // Kiralamayı ID'ye göre sil
    public void deleteRental(long rentID) {
        Rental rental = rentalRepository.findById(rentID)
            .orElseThrow(() -> new RuntimeException("Rental not found"));
        rentalRepository.delete(rental);
    }

    // Kiralamayı güncelle
    public Rental updateRental(long rentID, Rental rentalDetails) {
        Rental rental = rentalRepository.findById(rentID)
            .orElseThrow(() -> new RuntimeException("Rental not found"));

        rental.setRentalStartDate(rentalDetails.getRentalStartDate());
        rental.setRentalEndDate(rentalDetails.getRentalEndDate());
        rental.setPerson(rentalDetails.getPerson());
        rental.setCar(rentalDetails.getCar());

        // Güncellenmiş kiralama süresi hesapla
        long rentalDays = ChronoUnit.DAYS.between(rental.getRentalStartDate(), rental.getRentalEndDate());
        if (rentalDays <= 0) {
            throw new IllegalArgumentException("Kiralama süresi geçersiz");
        }
        rental.setRentalDays(rentalDays);

        return rentalRepository.save(rental);
    }

	

}



