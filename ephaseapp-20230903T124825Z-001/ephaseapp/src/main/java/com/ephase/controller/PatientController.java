package com.ephase.controller;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ephase.model.Patient;
import com.ephase.service.impl.PatientServiceImpl;

@RestController
@RequestMapping("/api")
public class PatientController {
	
	@Autowired
	private PatientServiceImpl patientServiceImpl;
	
	
	    @PostMapping("createPatient")
	    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
	    	Patient createdPatient = patientServiceImpl.createPatient(patient);
	        return new ResponseEntity<Patient>(patientServiceImpl.createPatient(patient),HttpStatus.CREATED);
	    }
	    
	    
	    @GetMapping("/getPatientAge")
	    public List<Patient> getPatientInAgeRange(
	            @RequestParam int minAge,
	            @RequestParam int maxAge) {
	        return patientServiceImpl.getPatientBetweenAges(minAge, maxAge);
	    }
	    
	    @GetMapping("/getAllPatient")
	    public ResponseEntity<List<Patient>> getAllPatient() {
	        List<Patient> patient = patientServiceImpl.getAllPatient();
	        return ResponseEntity.ok(patient);
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<Patient> getUserById(@PathVariable int id) {
	        Patient patient = patientServiceImpl.getPatientById(id);
	        if (patient != null) {
	            return ResponseEntity.ok(patient);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @GetMapping("/getmarriedPatient")
	    public List<Patient> getMarriedPatient(
	            @RequestParam String martialStatus ) {
	        return patientServiceImpl.findMarriedPatient();
	    }
	    
	    @GetMapping("/getPatientByCity")
	    public List<Patient> getPatientByCity(
	            @RequestParam String city ) {
	        return patientServiceImpl.findPatientByCity();
	    }
	    
	    @GetMapping("/getPatientByName")
	    public List<Patient> getPatientByName(@RequestParam String name) {
	        return patientServiceImpl.getPatientByName(name);
	    }
	    
	    @GetMapping("/between-dates")
	    public ResponseEntity<List<Patient>> getPatientsBetweenDates(
				@RequestParam("startDate") Date startDate,
				@RequestParam("endDate")  Date endDate) {

	        List<Patient> patients = patientServiceImpl.getPatientBetweenDates(startDate, endDate);
	        return ResponseEntity.ok(patients);
	    }
	    
	    @GetMapping("/starts-with")
	    public ResponseEntity<List<Patient>> getPatientsWithNameStartingWith(
	            @RequestParam("prefix") String prefix) {

	        List<Patient> patients = patientServiceImpl.getPatientsWithNameStartingWith(prefix);
	        return ResponseEntity.ok(patients);
	    }
	    
	    @GetMapping("/sorted-cities")
	    public ResponseEntity<List<String>> getAllCitiesInSortedOrder() {
	        List<String> cities = patientServiceImpl.getAllCityInSortedOrder();
	        return ResponseEntity.ok(cities);
	    }
	    
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Patient> updatePatient(@PathVariable int id, @RequestBody Patient patient) {
	    	Patient updatedPatient = patientServiceImpl.updatePatient(id, patient);
	        if (updatedPatient != null) {
	            return ResponseEntity.ok(updatedPatient);
	        }
	        return ResponseEntity.notFound().build();
	    }
	    
	    @GetMapping("/unique-country")
	    public ResponseEntity<List<String>> getUniqueCountry() {
	        List<String> countries = patientServiceImpl.getCountry();
	        return ResponseEntity.ok(countries);
	    }
	    
	    @GetMapping("/unique-contry-names")
	    public ResponseEntity<Set<String>> getUniqueCountryNames() {
	        Set<String> uniqueCountryNames = patientServiceImpl.getUniqueCountryNames();
	        return ResponseEntity.ok(uniqueCountryNames);
	    }
	    

}
