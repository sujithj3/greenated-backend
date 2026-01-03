package com.project.greenated.model;

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
@Table(name = "farmers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer farmerId;

    private String farmerName;
    private String contactNo;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Countries country;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private States state;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}