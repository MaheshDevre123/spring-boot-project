package com.fourserveglobal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fourserveglobal.entity.Book;
import com.fourserveglobal.entity.Student;
import com.fourserveglobal.repository.BookRepository;
import com.fourserveglobal.repository.StudentRepository;

@SpringBootApplication
public class ManyToOneMappingDemoApplication /* implements CommandLineRunner */ {

	public static void main(String[] args) {
		SpringApplication.run(ManyToOneMappingDemoApplication.class, args);
	}
    
	/*
	 * @Autowired private BookRepository bookRepository;
	 * 
	 * @Autowired private StudentRepository studentRepository;
	 * 
	 * @Override public void run(String... args) throws Exception { 
	 * sBook book1 = new
	 * Book("Ramayana"); Book book2 = new Book("Mahabhara");
	 * 
	 * bookRepository.save(book1); bookRepository.save(book2);
	 * 
	 * Student student1 = new Student("Mahesh", book1); Student student2 = new
	 * Student("Ravi",book1); Student student3 = new Student("Akshay", book2);
	 * Student student4 = new Student("Ashish", book2);
	 * 
	 * studentRepository.save(student1); studentRepository.save(student2);
	 * studentRepository.save(student3); studentRepository.save(student4);
	 * 
	 * }
	 */
}
