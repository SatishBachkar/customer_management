package com.customer.customermanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( length = 10)
	private int custId;
	
	@Column( length = 40)
	private String custName;
	
	@Column( length = 50)
	private String custAddress;
	
	@Column( length = 30)
	private String email;
	
	@Column( length = 30)
	private String password;
	
	@Column( length = 12)
	private Long phoneNumber;
}
