package com.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.car.model.RentCompany;

public interface CompanyRepository extends JpaRepository<RentCompany, Long>{

}
