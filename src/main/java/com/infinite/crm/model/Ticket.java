package com.infinite.crm.model;

import jakarta.persistence.Column;
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
@Table(name = "ticket1")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {                                   // ticket pojo

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long tid;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "issue")
	private String issue;

	@Column(name = "status")
	private String status;
	
	@Column(name = "raiseddate")
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	private String raiseddate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="users_email")
	private User users;

	}
