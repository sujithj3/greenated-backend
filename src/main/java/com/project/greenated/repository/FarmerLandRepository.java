package com.project.greenated.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.greenated.model.FarmerLand;

@Repository
public interface FarmerLandRepository extends JpaRepository<FarmerLand,Integer>{
	
	 @Query("""
		        SELECT fl FROM FarmerLand fl
		        WHERE fl.user.userId = :userId
		          AND fl.category.categoryId = :categoryId
		    """)
		    List<FarmerLand> findByUserAndCategory(
		            @Param("userId") Integer userId,
		            @Param("categoryId") Integer categoryId
		    );

}
