package com.infinite.crm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name="useraddress")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String number;
	private int pincode;
	private String area;
	private String landmark;
	private String state;
	private String country;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="users_email")
	private User users;

	}
