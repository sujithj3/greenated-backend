package com.project.greenated.model;

import jakarta.persistence.Column;
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
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categories {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "category_id")
	 private Integer categoryId;

	 @Column(name = "name", nullable = false)
	 private String name;
	 
	 @ManyToOne
	 @JoinColumn(name = "parent_id")
	 private Categories parentId;

	 @Column(name = "description")
	 private String description;

}
