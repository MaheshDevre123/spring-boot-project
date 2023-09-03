package com.fourserveglobal.service;

import java.util.List;

import com.fourserveglobal.model.Employee;
import com.fourserveglobal.model.Project;

public interface EmployeeService {
	public  Employee saveEmpoyee(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int id);
	public void deleteEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public boolean isEmployeeExist(int id);
	/*
	 * public List<Student> getAllStudent(); public Student getStudentById(int id);
	 * public boolean isStudentExist(int id); public void deleteStudent(Student
	 * student); public Student updateStudent(Student student, int id);
	 */
}
