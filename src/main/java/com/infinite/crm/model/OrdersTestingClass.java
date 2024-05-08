package com.infinite.crm.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name="orderstestingclass")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersTestingClass {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int orderid;
	
	private String username;
	
	@Column(name="email")
	private String email;
	
	private String pname;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	private LocalDate orderdate;
	
	private Long totalprice;
	
	private String address;
}
