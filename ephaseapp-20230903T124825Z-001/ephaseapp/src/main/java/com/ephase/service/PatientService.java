package com.ephase.service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.ephase.model.Patient;

public interface PatientService {
	
	Patient createPatient(Patient patient);
	
	List<Patient> getPatientBetweenAges(int minAge, int maxAge);
	
	List<Patient> getAllPatient();

	Patient getPatientById(int id);
	
	Patient updatePatient(int id, Patient patient);

    void deletePatient(int id);
    
    List<Patient> findMarriedPatient();
    
    List<Patient> findPatientByCity();
    
    public List<Patient> getPatientByName(String name);
    
    public List<Patient> getPatientBetweenDates(Date startDate, Date endDate);
    
    public List<Patient> getPatientsWithNameStartingWith(String prefix);
    
    public List<String> getAllCityInSortedOrder();
    
    public List<String> getCountry();
    
    public Set<String> getUniqueCountryNames();
    
    
	
}
