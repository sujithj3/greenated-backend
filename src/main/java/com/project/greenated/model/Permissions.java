package com.project.greenated.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="permissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permissions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer permissionId;
	
	@Column(name="permission_key",nullable = false)
	private String permissionkey;
	
}
