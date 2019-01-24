package com.accolite.Hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int id;
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	private String cs;
	//8) One To Many Mapping
	@OneToMany
	Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCs() {
		return cs;
	}
	public void setCs(String cs) {
		this.cs = cs;
	}
}
