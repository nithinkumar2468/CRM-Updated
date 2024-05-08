package com.infinite.crm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin1")
public record Admin (
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	 Long id,
	 String email,
	 String password
	)
{

}

