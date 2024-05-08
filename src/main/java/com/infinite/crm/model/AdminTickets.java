package com.infinite.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminTickets {
	
	private Long tid;
	private String username;
	private String email;
	private String issue;
	private String status;
}
