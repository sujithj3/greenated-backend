package com.project.greenated.model;

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
@Table(name = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;
    
    @Column(name="country_code")
    private String countryCode;
    
    @Column(name="country_name")
    private String countryName;
}