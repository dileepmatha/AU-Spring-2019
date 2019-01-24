package com.accolite.Hibernate.model;

import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Student {
	
	// 3) Primary Keys
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fname;
	private String lname;
	//5) AttributeOverrides and Embedded Objects
	private int age;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name = "permanent_street")),
		@AttributeOverride(name = "city", column = @Column(name = "permanent_city")),
		@AttributeOverride(name = "dno", column = @Column(name = "permanent_dno"))
	})
	private Address permanent_address;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name = "present_street")),
		@AttributeOverride(name = "city", column = @Column(name = "present_city")),
		@AttributeOverride(name = "dno", column = @Column(name = "present_dno"))
	})
	private Address present_address;
	
	public Address getPermanent_address() {
		return permanent_address;
	}
	public Address getPresent_address() {
		return present_address;
	}
	public void setPresent_address(Address present_address) {
		this.present_address = present_address;
	}
	public void setPermanent_address(Address address) {
		this.permanent_address = address;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Studen = [lname:"+lname+", fname:-"+fname+"]";
	}
	
}
