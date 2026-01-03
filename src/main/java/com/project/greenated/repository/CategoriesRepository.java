package com.project.greenated.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.greenated.model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
	@Query(value = "SELECT * FROM categories WHERE parent_id IS NULL", nativeQuery = true)
	List<Categories> getMainCategories();

	@Query(value = "SELECT * FROM categories WHERE parent_id = :parentId", nativeQuery = true)
	List<Categories> getSubCategories(@Param("parentId") Integer parentId);
}
