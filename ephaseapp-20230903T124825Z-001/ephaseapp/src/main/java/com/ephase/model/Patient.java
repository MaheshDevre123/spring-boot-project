package com.ephase.model;

import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "patient_name")
	private String name;
	
	@Column(name = "patient_city")
	private String city;
	
	@Column(name = "patient_isActive")
	private boolean alive;
	
	@Column(name = "patient_emailId")
	private String emailId;
	
	@Column(name = "patient_martialStatus")
	private String martialStatus;
	
	@Column(name = "patient_country")
	private String country;
	
	@Column(name = "patient_phoneNumber")
	private String phoneNumber;
	
	@Column(name = "patient_age")
	private int age;
	
	@Column(name = "zipcode")
	private String zipcode;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "date_of_joining")
	private Date dateOfJoining;
	
	
	public Patient() {
		super();
	}

	public Patient(int id, String name, String city, boolean alive, String emailId, String martialStatus,
			String country, String phoneNumber, int age, String gender, String zipcode, Date dateOfJoining) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.alive = alive;
		this.emailId = emailId;
		this.martialStatus = martialStatus;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.gender=gender;
		this.zipcode=zipcode;
		this.dateOfJoining=dateOfJoining;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}
    
	public void setCity(String city) {
		this.city = city;
	}

	public boolean getAlive() {
		return alive;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void setActive(boolean alive) {
		this.alive = alive;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	
	
	
	

}
