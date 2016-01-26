package com.acadgild.tml.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author TML
 *
 */
@Entity
public class Employee {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private String phone;
	private String location;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, String email, String phone, String location) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", location=" + location + "]";
	}

	
}
