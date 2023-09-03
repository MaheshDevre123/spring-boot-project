package com.ephase.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ephase.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer>{
	

	 @Query("SELECT patient FROM Patient patient WHERE patient.age BETWEEN :minAge and :maxAge")
	 List<Patient> findPatientBetweenAges(int minAge, int maxAge);
	 
	 @Query("SELECT patient FROM Patient patient where patient.martialStatus='Married'")
	 public List<Patient> findMarriedPatient();
	 
	 @Query("SELECT patient FROM Patient patient where patient.city='California'")
	 public List<Patient> findPatientByCity();
	 
	 @Query("SELECT patient FROM Patient patient WHERE patient.name = ?1")
	 List<Patient> findPatientByName(String name);
	 
	 List<Patient> findAll();
	 
	 @Query("SELECT DISTINCT patient.country FROM Patient patient ")
     public List<String> getCountry();
	 
}
