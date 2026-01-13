package com.project.greenated.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "farmer_land")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmerLand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "land_id")
	private Integer landId;

	@Column(name = "project_id")
	private Integer projectId;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "land_area")
	private Double landArea;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;

	@Column(name = "species")
	private String species;

	@Column(name = "planting_date")
	private LocalDate plantingDate;

	@ManyToOne
	@JoinColumn(name = "farmer_id")
	private Farmer farmer;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Categories category;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Countries country;

	@ManyToOne
	@JoinColumn(name = "state_id")
	private States state;

	@ManyToOne
	@JoinColumn(name = "district_id")
	private Location district;

	@Column(name = "status")
	private Integer status;

	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;
}
