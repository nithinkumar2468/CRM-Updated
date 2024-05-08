package com.infinite.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressDTO {
	
	private Long id;
	private String name;
	private String number;
	private int pincode;
	private String area;
	private String landmark;
	private String state;
	private String country;

}
