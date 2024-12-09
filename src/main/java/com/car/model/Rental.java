package com.car.model;



import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="rent_car")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rentID;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
    private Person person;
	
	@ManyToOne
	@JoinColumn(name="car_id")
    private Car car;
    
	@Column(name="start_date")
    private LocalDate rentalStartDate;
    
	@Column(name="end_date")
    private LocalDate rentalEndDate;
    
	@Column(name="rent_day")
    private long rentalDays;


    /* Tabloda gösterilecek veriyi döndüren metot
    public String getRentalDetails() {
        return String.format("%d\t%d\t%s\t%s\t%d",
                customerId, carId, rentalStartDate, rentalEndDate, rentalDays);
    }*/

}