package com.fourserveglobal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourserveglobal.exception.ErrorDetails;

import com.fourserveglobal.model.Employee;
import com.fourserveglobal.repository.EmployeeRepository;
import com.fourserveglobal.service.EmployeeService;



@Service
public class EmployeeServiceImpl implements EmployeeService{
	//@Autowired
	private EmployeeRepository employeeRepository ;
	
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


     //for saving the data
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}


     //for getting the all records
	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}


     //for fetching the employee  by id
	@Override
	public Employee getEmployeeById(long id) {
		/*Optional<Employee> employee=employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}*/
		
		//by lambda expression
		
		return employeeRepository.findById(id).orElseThrow(()->
		  new ErrorDetails());
	}


     // for update
	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//we need to check whether employee with given id is exist in DB or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				()->new ErrorDetails());
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		//save existing employee to DB
		
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}


    //for delete
	@Override
	public void deleteEmployee(long id) {
		//check whether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow(()->
		new ErrorDetails());
		employeeRepository.deleteById(id);
		
	}


	@Override
	public boolean isEmployeeExist(long id) {
		
		return employeeRepository.existsById(id);
	}
	



	
	
	
	
	
	
	
   
}
