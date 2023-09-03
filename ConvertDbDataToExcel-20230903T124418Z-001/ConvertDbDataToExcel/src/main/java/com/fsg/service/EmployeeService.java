package com.fsg.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.fsg.entity.Employee;

public interface EmployeeService {
	
	public ByteArrayInputStream generateExcelReport() throws IOException;
	
	public Employee saveEmployee(Employee employee);

}
