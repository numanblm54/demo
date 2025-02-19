package com.car.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="company")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="company_name")
    private String companyName;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> address;
    
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> car;
}
