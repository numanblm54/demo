package com.car.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="car")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name="brand")
	 private String brand;
	 
	 @Column(name="model")
	 private String model;
	 
	 @Column(name="year")
	 private int year;
	 
	 @Column(name="color")
	 private String color;
	 
	 @Column(precision = 10, scale = 2)
	 private BigDecimal price;

}
