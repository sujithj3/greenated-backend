package com.project.greenated.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.greenated.model.Countries;
@Repository
public interface CountryRepository extends JpaRepository<Countries, Integer> {

}
