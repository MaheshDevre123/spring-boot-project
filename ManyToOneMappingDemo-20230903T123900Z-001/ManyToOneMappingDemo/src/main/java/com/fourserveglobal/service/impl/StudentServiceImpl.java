package com.fourserveglobal.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourserveglobal.entity.Book;
import com.fourserveglobal.entity.Student;
import com.fourserveglobal.exception.ErrorDetails;
import com.fourserveglobal.repository.BookRepository;
import com.fourserveglobal.repository.StudentRepository;
import com.fourserveglobal.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private BookRepository bookRepository;
    
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		
		return studentRepository.findById(id).orElseThrow(()->
		  new ErrorDetails());
	}

	@Override
	public boolean isStudentExist(int id) {
		
		Student student = new Student();
		return studentRepository.existsById(id);
	}

	@Override
	public void deleteStudent(Student student) {
		//studentRepository.findById(id).orElseThrow(()-> new ErrorDetails());
		studentRepository.delete(student);
		
	}

	@Override
	public Student updateStudent(Student student, int id) {
		//student object
        Student existingStudent = studentRepository.findById(id).orElseThrow();
		existingStudent.setSid(student.getSid());
	    existingStudent.setSname(student.getSname());
	     
	    //Book object
	    Book existingBook =new Book();
	    existingBook.setBookId(student.getBook().getBookId());
	    existingBook.setBookName(student.getBook().getBookName());
	     
	   existingStudent.setBook(existingBook);
	   return  studentRepository.save(existingStudent);
	  
	}

	
	

}
