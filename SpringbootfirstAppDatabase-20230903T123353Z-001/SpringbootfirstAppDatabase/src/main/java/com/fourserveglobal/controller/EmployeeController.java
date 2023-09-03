package com.fourserveglobal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fourserveglobal.exception.ErrorDetails;

import com.fourserveglobal.model.Employee;
import com.fourserveglobal.service.EmployeeService;

@RestController
@RequestMapping("/api/employees1")
public class EmployeeController {
	
    private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//build create employee Rest API
    @PostMapping
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
    	
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
    
    //build get all employee Rest API
    @GetMapping
    public List<Employee> getAllEmployee(){
    	return employeeService.getAllEmployees();
    }
    
    //build get employee by id Rest Api
    // http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@Valid @PathVariable("id") long id)
    {
    	
    	boolean isEmployeeExist=employeeService.isEmployeeExist(id);
    	if(isEmployeeExist) {
    	return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    	}
    	else {
    	throw new ErrorDetails("Employee is not available  : "+id);
    	}
    }
    
    //build update employee Rest API
    //http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@Valid @PathVariable("id") long id,
    		@RequestBody Employee employee)  {
    	boolean isEmployeeExist=employeeService.isEmployeeExist(id);
    	if(isEmployeeExist) {
    	return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    	}
    	else {
    	throw new ErrorDetails("Employee is not available "+id);
    	}
    }
    
    //built delete employee Rest API
    //http://localhost:8080/api/employees/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
    	//delete employee from DB
    	boolean isEmployeeExist=employeeService.isEmployeeExist(id);
    	if(isEmployeeExist) {
    	employeeService.deleteEmployee(id);
    	return new ResponseEntity<String>("Employee Deleted successfully ", HttpStatus.OK);
    	}else
    	{
    		throw new ErrorDetails("Employee is not available : "+id);
    	}
    	
    }
    
    
}
