package com.fourserveglobal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourserveglobal.exception.ErrorDetails;
import com.fourserveglobal.model.Employee;
import com.fourserveglobal.model.Project;
import com.fourserveglobal.repository.EmployeeRepository;
import com.fourserveglobal.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmpoyee(Employee employee) {
		
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(int id) {
		
		return employeeRepository.findById(id).orElseThrow(()->
		  new ErrorDetails());
	}


	@Override
	public boolean isEmployeeExist(int id) {
		
		return employeeRepository.existsById(id);
	}


	@Override
	public void deleteEmployee(Employee employee) {
		 employeeRepository.delete(employee);
	}


	@Override
	public Employee updateEmployee(Employee employee) {
		
		Employee employee1 = new Employee();
		employee1= employeeRepository.findById(employee.getEid()).orElseThrow();
		employee1.setEid(employee.getEid());
		employee1.setEname(employee.getEname());
		employee1.setEsalary(employee.getEsalary());
		
		
		List<Project> project= new ArrayList<>();
		for(Project pr : employee.getProjects()) {
			Project  projects= new Project();
			projects.setPid(pr.getPid());
			projects.setPname(pr.getPname());
			project.add(projects);
			
		}
		employee.setProjects(project);
		return employeeRepository.save(employee);
	}


	




	
}
