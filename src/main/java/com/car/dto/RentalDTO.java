package com.car.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalDTO {
	
	private String firstName;
	private String lastName;
	private String city;
	private String brand;
	private String model;

}
