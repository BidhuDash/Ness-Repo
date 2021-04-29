package com.NessSpring.NessSpring_ORM_Pract3.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;
import com.NessSpring.NessSpring_ORM_Pract3.entities.EmployeeModel;


public class EmployeeDao {
	private HibernateTemplate hibernateTemplate;
	
	//save employee
	@Transactional
	public int addEmployees(EmployeeModel employeeModel) {
		Integer rows=(Integer)hibernateTemplate.save(employeeModel);
		return rows;
	}
	//get employee by id
	public EmployeeModel getEmployeesById(int id) {
		EmployeeModel emp= hibernateTemplate.get(EmployeeModel.class,id);
		return emp;
	}
	
	//get ALL employees
	public List<EmployeeModel> getEmployees(){
		List<EmployeeModel> emplist= hibernateTemplate.loadAll(EmployeeModel.class);
		return emplist;
	}
	//update employee
	@Transactional
	public void  updateEmployee(EmployeeModel updateemp) {
		hibernateTemplate.update(updateemp);
	}
	
	//delete employee
	@Transactional
	public void deleteEmployee(EmployeeModel deleteemp ) {
		hibernateTemplate.delete(deleteemp);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
