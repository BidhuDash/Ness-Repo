package com.BEEmp.EmployeeBackEnd.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BEEmp.EmployeeBackEnd.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	Employee getEmployeeById(Long id);

}
