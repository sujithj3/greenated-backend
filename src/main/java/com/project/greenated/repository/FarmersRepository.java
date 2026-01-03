package com.project.greenated.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.greenated.model.Farmer;


@Repository
public interface FarmersRepository extends JpaRepository<Farmer, Integer> {

    @Query(value = """
        SELECT f.*
        FROM farmers f
        JOIN users u ON u.user_id = f.user_id
        WHERE u.user_id = :userId
           OR u.parent_id = :userId
        """, nativeQuery = true)
    List<Farmer> findFarmersByUserAndParent(@Param("userId") Integer userId);
}