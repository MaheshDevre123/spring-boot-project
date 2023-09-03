package com.fourserveglobal.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee_table")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String ename;
	private double esalary;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "eid"), inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "pid"))
	private List<Project> projects;

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	

	public Employee(String ename, double esalary, List<Project> projects) {
		super();
		this.ename = ename;
		this.esalary = esalary;
		this.projects = projects;
	}

	/*
	 * private Set<Project> project;
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String ename, double esalary) {
		super();
		this.ename = ename;
		this.esalary = esalary;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getEsalary() {
		return esalary;
	}

	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}

	/*
	 * public Set<Project> getProject() { return project; }
	 * 
	 * public void setProject(Set<Project> project) { this.project = project; }
	 */

}
