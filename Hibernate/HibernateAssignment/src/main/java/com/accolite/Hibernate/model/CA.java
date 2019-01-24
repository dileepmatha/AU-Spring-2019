package com.accolite.Hibernate.model;

import javax.persistence.*;


//10) Inheritance
@Entity
@Table(name = "CA")
@DiscriminatorValue("CA")
public class CA extends Employee{

	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
