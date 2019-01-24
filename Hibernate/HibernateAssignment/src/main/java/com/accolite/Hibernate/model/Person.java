package com.accolite.Hibernate.model;

import java.util.Date;

import javax.persistence.*;

//15) Named Queries
@NamedQueries({
	@NamedQuery(name = "All", query="from Person"),
	@NamedQuery(name = "GT5", query="select id from Person where id>6")
})

@Entity
public class Person {

	@Id
	@GeneratedValue
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	private String pname;
	private String address;
	private Date dob;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String toString() {
		return "Person [pname:"+pname+", Id:"+id+", dob:"+dob+", address:"+address+"]";
	}
	
}
