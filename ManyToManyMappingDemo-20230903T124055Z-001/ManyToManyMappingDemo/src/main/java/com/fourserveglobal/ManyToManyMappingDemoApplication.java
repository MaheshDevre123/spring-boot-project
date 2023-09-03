package com.fourserveglobal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fourserveglobal.model.Employee;
import com.fourserveglobal.model.Project;
import com.fourserveglobal.repository.EmployeeRepository;
import com.fourserveglobal.repository.ProjectRepository;

@SpringBootApplication
public class ManyToManyMappingDemoApplication /* implements CommandLineRunner */{

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyMappingDemoApplication.class, args);
	}
/*
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Employee employee1 = new Employee("Mahesh",300000);
		
		Project project1 = new Project("Solcon");
		Project project2 = new Project("Four Serv Portal");
		
		
		employee1.getProject().add(project1);
		employee1.getProject().add(project2);
		
		project1.getEmployee().add(employee1);
		project2.getEmployee().add(employee1);
		
		
		
		
		this.employeeRepository.save(employee1);
		}*/
		
		
		
		
	

}
