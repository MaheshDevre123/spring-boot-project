package com.fsg.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsg.entity.Employee;
import com.fsg.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public ByteArrayInputStream generateExcelReport() throws IOException {
		List<Employee> employees = employeeRepo.findAll();
		
		try(Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = (Sheet) workbook.createSheet("Employee Data");
			
			 // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("First Name");
            headerRow.createCell(2).setCellValue("Last Name");
            headerRow.createCell(3).setCellValue("Date of Birth");
            headerRow.createCell(4).setCellValue("Salary");
            headerRow.createCell(5).setCellValue("Date of Joining");
            
            
			int rowNum = 1;
			
			for (Employee employee : employees) {
                Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(rowNum++);
                row.createCell(0).setCellValue(employee.getId());
                row.createCell(1).setCellValue(employee.getFirstName());
                row.createCell(2).setCellValue(employee.getLastName());
                row.createCell(3).setCellValue(employee.getDateOfBirth().toString());
                row.createCell(4).setCellValue(employee.getSalary());
                
                // Format the date field
                Cell dateCell = row.createCell(5);
                CellStyle dateCellStyle = workbook.createCellStyle();
                CreationHelper createHelper = workbook.getCreationHelper();
                dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));
                dateCell.setCellValue(employee.getDateOfJoining());
                dateCell.setCellStyle(dateCellStyle);
            }
			
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		workbook.write(arrayOutputStream);
		
		return new ByteArrayInputStream(arrayOutputStream.toByteArray());
	}

}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}
	
}
