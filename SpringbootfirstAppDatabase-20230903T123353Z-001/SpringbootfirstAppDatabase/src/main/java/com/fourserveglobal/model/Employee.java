package com.fourserveglobal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees1")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "first_name", nullable = false)
	@NotNull(message = "FIRSTNAME IS REQUIRED")
	@Size(min = 2, message = "size should not be less than two character ")
	private String firstName;

	@Column(name = "last_name")
	@NotNull(message = "LASTNAME IS REQUIRED")
	@Size(min = 2, message = "size should not be less than two character ")
	private String lastName;

	@Column(name = "email_id")
	@NotNull(message = "EMAIL IS REQUIRED")
	@Email
	@Pattern(regexp = "^[a-z]{1,10}[@]{1}[a-z]{3}[.]{1}[a-z]{3}", message = "Email is ends with @fsg.com")
	private String email;

	@NotNull(message = "PASSWORD IS REQUIRED")
	@Size(min = 8, message = "size should not be less than 8 character ")
	private String password;

	// Default Constructor
	public Employee() {
		super();

	}

	// Parameterized constructor
	public Employee(long id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	// Getters and Setters
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
