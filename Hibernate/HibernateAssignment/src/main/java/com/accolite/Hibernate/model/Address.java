package com.accolite.Hibernate.model;

import javax.persistence.Embeddable;


//4) Value Types
@Embeddable
public class Address {
	private int dno;
	private String city;
	private String street;
	
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
}
