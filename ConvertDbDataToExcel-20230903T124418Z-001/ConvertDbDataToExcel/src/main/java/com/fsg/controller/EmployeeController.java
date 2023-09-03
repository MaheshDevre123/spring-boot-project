package com.fsg.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsg.entity.Employee;
import com.fsg.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/excel")
public class EmployeeController {
	
	@Autowired
    private EmployeeServiceImpl excelService;

    @GetMapping("/report")
    public ResponseEntity<InputStreamResource> generateExcelReport() throws IOException {
        ByteArrayInputStream excelReport = excelService.generateExcelReport();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=employee_report.xlsx");

        return ResponseEntity
            .ok()
            .headers(headers)
            .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
            .body(new InputStreamResource(excelReport));
    }
    
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
		return excelService.saveEmployee(employee);
    	
    }

}

//InputStreamResource is a class provided by Spring Framework that wraps an InputStream and can be used to represent a resource that can be read 
//as an input stream.  It's often used in scenarios where you want to provide a resource as a response, such as a downloadable file, 
//through a Spring MVC controller.
//
//In the context of your Spring Boot application generating an Excel report, you can use InputStreamResource to wrap the 
//ByteArrayInputStream containing the generated Excel data.
//This allows you to provide the Excel report as a response in your controller.

//ByteArrayInputStream is a class in Java that is part of the java.io package and is used for reading data from a byte array as if it were 
//an input stream. It allows you to treat a byte array as a source of input data, which can be useful in various scenarios, such as reading 
//serialized objects, parsing binary data, or working with in-memory data.


//HttpHeaders is a class in Java that is part of various HTTP-related libraries and frameworks, such as the Spring Framework and the 
//Java Servlet API. It is used to represent and manipulate the HTTP headers of an HTTP request or response. HTTP headers contain metadata 
//about the data being sent or received in an HTTP message.
