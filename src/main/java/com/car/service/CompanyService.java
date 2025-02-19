package com.car.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.model.Address;
import com.car.model.Car;
import com.car.model.RentCompany;
import com.car.repository.CompanyRepository;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRepo;
	
	public void createCompany() {
		companyRepo.saveAllAndFlush(company());
	}
	
	private List<RentCompany> company(){
		
		List<RentCompany> list = new ArrayList();
		RentCompany company1 = new RentCompany();
		RentCompany company2 = new RentCompany();
		company1.setCompanyName("A");
		company1.setCar(List.of(
				new Car("Fiat", "Egea",2019 ,"Red", 20000),
				new Car("Wolkswagen","Jetta",2018,"Black",30000)
				));
		company1.setAddress(List.of(
				new Address("Pazar","İstanbul","34","Turkey"),
				new Address("Yazlık","Sakarya","54","Turkey"))
				);
		
		company2.setCompanyName("B");
		company2.setCar(List.of(
				new Car("Peugeot", "3005",2017 ,"Blue", 25000),
				new Car("Opel", "Corsa",2021 ,"Grey", 10000))
				);
		company2.setAddress(List.of(
				new Address("Kavakpınar","Sakarya","54","Turkey"),
				new Address("Kaynarca","İstanbul","34","Turkey"))
				);
		
		
		list.add(company1);
		list.add(company2);
		return list;
	}

}
