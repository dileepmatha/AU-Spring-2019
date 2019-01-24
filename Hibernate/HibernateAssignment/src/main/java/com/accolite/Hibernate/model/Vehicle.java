package com.accolite.Hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	private int id;
	private String name1;
	//7) One to One Mapping
	//9)Cascade Types
	@OneToOne(cascade = CascadeType.ALL)
	private Address ad;
	public Address getAd() {
		return ad;
	}
	public void setAd(Address ad) {
		this.ad = ad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
}
