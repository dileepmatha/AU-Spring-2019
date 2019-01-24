package com.accolite.Hibernate.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorValue("EMP_TYPE")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String emp_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
}
