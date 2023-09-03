package com.ephase.service.impl;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ephase.model.Patient;
import com.ephase.repo.PatientRepo;
import com.ephase.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientRepo patientRepo;
	
	

	@Override
	public Patient createPatient(Patient patient) {
		return patientRepo.save(patient);
	}



	@Override
	public List<Patient> getPatientBetweenAges(int minAge, int maxAge) {
		return patientRepo.findPatientBetweenAges(minAge, maxAge);
	}



	@Override
	public List<Patient> getAllPatient() {
		return patientRepo.findAll();
	}



	@Override
	public Patient getPatientById(int id) {
		return patientRepo.findById(id).orElse(null);
	}



	@Override
	public Patient updatePatient(int id, Patient patient) {

		Patient patients = patientRepo.findById(id).orElse(null);
	        if (patients != null) {
	        	patients.setName(patient.getName());
//	        	patients.setCity(patient.getCity());
//	            patients.setAlive(patient.getAlive());
//	            patients.setEmailId(patient.getEmailId());
//	            patients.setMartialStatus(patient.getMartialStatus());
//	            patients.setCountry(patient.getCountry());
//	            patients.setPhoneNumber(patient.getPhoneNumber());
//	            patients.setAge(patient.getAge());
//	            patients.setZipcode(patient.getZipcode());
//	            patients.setGender(patient.getGender());
//	            patients.setDateOfJoining(patient.getDateOfJoining());
	            return patientRepo.save(patients);
	        }
	        return null;
	}



	@Override
	public void deletePatient(int id) {
		patientRepo.deleteById(id);
		
	}



	@Override
	public List<Patient> findMarriedPatient() {
		return patientRepo.findMarriedPatient();
	}



	@Override
	public List<Patient> findPatientByCity() {
		return patientRepo.findPatientByCity();
	}



	@Override
	public List<Patient> getPatientByName(String name) {
		
		return patientRepo.findPatientByName(name);
	}



	@Override
	public List<Patient> getPatientBetweenDates(Date startDate, Date endDate) {
		List<Patient> allPatient = patientRepo.findAll(); 

        List<Patient> patientInRange = allPatient.stream()
            .filter(patient -> (patient.getDateOfJoining().equals(startDate) || patient.getDateOfJoining().after(startDate)) && (patient.getDateOfJoining().before(endDate)) || patient.getDateOfJoining().equals(endDate))
            .collect(Collectors.toList());

        return patientInRange;
	}


	 
	
	@Override
	public List<Patient> getPatientsWithNameStartingWith(String prefix) {
		
		
		
		List<Patient> allPatient = patientRepo.findAll(); 
		
		List<Patient> patientStartWith = allPatient.stream()
	            .filter(patient -> patient.getName().startsWith(prefix))
	            .collect(Collectors.toList());
		
		 return patientStartWith;

	}



	@Override
	public List<String> getAllCityInSortedOrder() {
		List<Patient> allPatient = patientRepo.findAll(); 

        return allPatient.stream()
                .map(Patient::getCity)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
	}



	@Override
	public List<String> getCountry() {
		List<String> CountryList = patientRepo.getCountry();
		return CountryList;
	}



	@Override
	public Set<String> getUniqueCountryNames() {
		List<Patient> allPatient = patientRepo.findAll();
        Set<String> uniqueCountryNames = new HashSet<>();

        for (Patient patient : allPatient) {
            uniqueCountryNames.add(patient.getCountry());
        }

        return uniqueCountryNames;
	}
}
