package com.NessSpring.NessSpring_ORM_Pract3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=" emptable")
public class EmployeeModel {
	@Id
	@Column(name="emp_id")
	private int id;
	
	@Column(name= "emp_name")
	private String name;
	
	@Column (name="emp_email")
	private String email;
	
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
	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
