package com.project.greenated.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.greenated.model.States;

@Repository
public interface StateRepository extends JpaRepository<States, Integer> {
	
	List<States> findByCountry_CountryId(Long countryId);

}
