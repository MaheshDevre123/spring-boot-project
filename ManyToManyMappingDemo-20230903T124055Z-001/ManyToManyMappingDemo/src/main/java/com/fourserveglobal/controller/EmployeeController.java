package com.fourserveglobal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fourserveglobal.exception.ErrorDetails;
import com.fourserveglobal.model.Employee;
import com.fourserveglobal.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("emp1")
	public Employee saveEmployee(@RequestBody Employee employee) {
    	return employeeService.saveEmpoyee(employee);
    }
	
	 // for fetching
    @GetMapping("allemp")
    public List<Employee> getAll() {
    	return employeeService.getAllEmployee();
    }
    
    // for fetching by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById( @PathVariable int id)
    {
    	
    	boolean isEmployeeExist=employeeService.isEmployeeExist(id);
    	if(isEmployeeExist) {
    	return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    	}
    	else {
    	throw new ErrorDetails("Employee is not available with id  = "+id);
    	}
    }
    
    //for update
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
    	boolean isEmployeeExist=employeeService.isEmployeeExist(id);
        if (isEmployeeExist) {
            return  new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
            		
        }
        else {
        	  throw new ErrorDetails("Employee is not available  : "+id);
        }
    }
	
    
    //for delete
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id, Employee employee){
    	//delete employee from DB
    	boolean isEmployeeExist=employeeService.isEmployeeExist(id);
    	if(isEmployeeExist) {
    	employeeService.deleteEmployee(employee);
    	return new ResponseEntity<String>("Employee Deleted successfully ", HttpStatus.OK);
    	}else
    	{
    		throw new ErrorDetails("Employee is not available : "+id);
    	}
    }
}
