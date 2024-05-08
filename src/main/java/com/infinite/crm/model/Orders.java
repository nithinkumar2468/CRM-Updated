package com.infinite.crm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders")
@SequenceGenerator(name="order_id_seq", initialValue=2000)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="order_id_seq")
	private Long orderid;

	@Column(name = "pname")
	private String pname;

	@Column(name = "totalprice")
	private String totalprice;

	@Column(name = "address")
	private String address;
	
	@Column(name = "ordereddate")
	private String ordereddate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="users_email")
	private User users;
}
