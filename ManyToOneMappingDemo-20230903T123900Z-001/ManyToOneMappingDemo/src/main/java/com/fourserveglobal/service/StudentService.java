package com.fourserveglobal.service;

import java.util.List;
import java.util.Optional;

import com.fourserveglobal.entity.Book;
import com.fourserveglobal.entity.Student;

public interface StudentService {
	public  Student saveStudent(Student student);
	public List<Student> getAllStudent();
	public Student getStudentById(int id);
	public boolean isStudentExist(int id);
	public void deleteStudent(Student student);
	public Student updateStudent(Student student, int id);
	
}
