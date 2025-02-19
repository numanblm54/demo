package com.car.dto;

import java.sql.Date;

import com.car.model.Address;
import com.car.model.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserMailDTO {

	private String firstName;
	private String lastName;
	private String Mail;
	
}
