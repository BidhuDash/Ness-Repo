package com.BEEmp.EmployeeBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BEEmp.EmployeeBackEnd.entity.Employee;
import com.BEEmp.EmployeeBackEnd.service.EmployeeSevice;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	public EmployeeSevice employeeSevice;

	@GetMapping("/testemployee")
	public String test() {
		return "Employee Working";
	}

	@GetMapping("/allemployees")
	public List<Employee> getAllEmployees() {
		return employeeSevice.findAll();
	}

	@GetMapping("/getemployee/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeSevice.getEmployeeById(id);
	}

	@PostMapping("/createemployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeSevice.createEmployee(employee);
	}

	@PutMapping("/updateemployee/{id}")
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable Long id) {
		return employeeSevice.updateEmployee(emp, id);
	}

	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeSevice.deleteEmployee(id);
		return "Employee Id:"+id+" deleted Successfully";

	}
}
