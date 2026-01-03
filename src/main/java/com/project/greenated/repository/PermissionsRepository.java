package com.project.greenated.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.greenated.model.Permissions;

@Repository
public interface PermissionsRepository extends JpaRepository<Permissions,Integer> {

}
