package com.infinite.crm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user1",uniqueConstraints= {
		@UniqueConstraint(columnNames= {"email"})
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {                         //user pojo

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobileno")
	private String mobileno;
	
	@Column(name="password")
	private String password;
	
	@Column(name="retypepassword")
	private String retypepassword;

	}
