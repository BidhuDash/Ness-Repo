package com.BEEmp.EmployeeBackEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BEEmp.EmployeeBackEnd.entity.Employee;
import com.BEEmp.EmployeeBackEnd.exception.EmployeeNotFoundException;
import com.BEEmp.EmployeeBackEnd.repository.EmployeeRepository;

@Service
public class EmployeeSevice {
	@Autowired
	public EmployeeRepository employeeRepository;
	
	//get all employees (working)
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	//get employee by id (working)
	public Employee getEmployeeById(Long id) {
		if(employeeRepository.existsById(id)){
			return employeeRepository.getEmployeeById(id);}
		else {
			throw new EmployeeNotFoundException("Employee Id " + id + " not found");
		}
	}
	
	// create new employee (working)
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	
	//update employee (working)
	public Employee updateEmployee(Employee emp1, Long id) {
		if (employeeRepository.existsById(id)) {
			Employee employee= new Employee();
			employee.setId(id);
			employee.setFirstName(emp1.getFirstName());
			employee.setLastName(emp1.getLastName());
			employee.setEmail(emp1.getEmail());

			return employeeRepository.saveAndFlush(employee);
		} else
			throw new EmployeeNotFoundException("Employee Id " + id + " not found");

	}

	//delete employee (working)
	public Employee deleteEmployee(Long id) {
		if (employeeRepository.existsById(id)) {
			 employeeRepository.deleteById(id);
			return null;
		} else
			throw new EmployeeNotFoundException("Employee Id " + id + " not found");
	}
	
	

}
