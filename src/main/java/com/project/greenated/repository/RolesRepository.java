package com.project.greenated.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.greenated.model.Roles;

public interface RolesRepository extends JpaRepository<Roles,Integer> {
	 Optional<Roles> findByRoleNameIgnoreCase(String roleName);

	    boolean existsByRoleNameIgnoreCase(String roleName);
}

