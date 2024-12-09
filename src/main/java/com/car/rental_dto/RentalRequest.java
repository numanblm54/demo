package com.car.rental_dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class RentalRequest {
	private Long personId;
    private Long carId;
    private LocalDate startDate;
    private LocalDate endDate;

}
