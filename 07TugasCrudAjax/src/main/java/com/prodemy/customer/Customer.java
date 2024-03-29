package com.prodemy.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String email;
	private String address;

	protected Customer() {
	}

	protected Customer(int id, String name, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
	}

}
