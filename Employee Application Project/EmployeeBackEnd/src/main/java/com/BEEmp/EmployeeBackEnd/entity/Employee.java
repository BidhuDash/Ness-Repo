package com.BEEmp.EmployeeBackEnd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="emptable")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="empid")
	private Long id;
	private String firstName;
	private String lastName;
	private String email;

}
