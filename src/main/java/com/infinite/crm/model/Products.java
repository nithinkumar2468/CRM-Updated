package com.infinite.crm.model;

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
@Table(name="products1")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Products { // products pojo

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "pname")
	private String pname;

	@Column(name = "rating")
	private String rating;

	@Column(name = "price")
	private Long price;

	@Column(name = "brand")
	private String brand;
}
