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
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer userId;
     
	 @Column( name ="name",nullable = false)
	 private String name;

	 @Column( name ="email",nullable = false, unique = true)
	 private String email;
     
	 @Column( name ="password_hash",nullable = false)
	 private String password;

	 @ManyToOne
	 @JoinColumn(name = "role_id", nullable = false)
	 private Roles roles;
	 
	 @ManyToOne
	    @JoinColumn(name = "parent_id")
	    private Users parent;
}
