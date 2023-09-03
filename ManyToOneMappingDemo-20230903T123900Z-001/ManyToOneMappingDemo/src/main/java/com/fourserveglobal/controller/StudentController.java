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

import com.fourserveglobal.entity.Book;
import com.fourserveglobal.entity.Student;
import com.fourserveglobal.exception.ErrorDetails;
import com.fourserveglobal.service.StudentService;

@RestController
public class StudentController {
  
	   @Autowired
	   private StudentService studentService;
	    
	   

		public StudentController(StudentService studentService) {
			super();
			this.studentService = studentService;
		}
	    
		@PostMapping("/student")
		public Student save(@RequestBody Student student) {
	    	return studentService.saveStudent(student);
	    }
		
		 // for fetching
	    @GetMapping("/allstudent")
	    public List<Student> getAll() {
	    	return studentService.getAllStudent();
	    }
	    
	    // for fetching by id
	    @GetMapping("{id}")
	    public ResponseEntity<Student> getStudentById( @PathVariable int id)
	    {
	    	
	    	boolean isStudentExist=studentService.isStudentExist(id);
	    	if(isStudentExist) {
	    	return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
	    	}
	    	else {
	    	throw new ErrorDetails("Student is not available  : "+id);
	    	}
	    }
	    

	     //for update
		 @PutMapping("{id}") 
		  public ResponseEntity<Student> updateStudent(@PathVariable("id") int id,@RequestBody Student student) { boolean
		  isStudentExist=studentService.isStudentExist(id); 
		  if(isStudentExist) { 
			  return new ResponseEntity<>(studentService.updateStudent(student,id), HttpStatus.CREATED); }
		  else {
		    throw new ErrorDetails("User is not available : "+id); 
		  }
		  }
	    //for delete
	    @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id, Student student){
	    	//delete employee from DB
	    	boolean isStudentExist=studentService.isStudentExist(id);
	    	if(isStudentExist) {
	    	studentService.deleteStudent(student);
	    	return new ResponseEntity<String>("Student Deleted successfully ", HttpStatus.OK);
	    	}else
	    	{
	    		throw new ErrorDetails("Student is not available : "+id);
	    	}
	    }
}
