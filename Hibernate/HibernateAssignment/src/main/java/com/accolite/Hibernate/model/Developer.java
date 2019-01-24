package com.accolite.Hibernate.model;

import javax.persistence.*;


//10) Implementing Inheritance (single table,joined table)
@Entity
@Table(name = "Developer")
@DiscriminatorValue("Developer")
public class Developer extends Employee{

	private String role;

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
