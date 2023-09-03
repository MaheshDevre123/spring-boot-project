package com.fsg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsg.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	

}
