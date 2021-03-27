package com.example.First;

import java.sql.Date;

public class Employee {
	int Id;
	String Name;
	String Phoneno;
	String Deptit;
	String Status;
	Date CreatedDTm;
	String CreatedBy;
	Date UpdatedDTm;
	String UpdatedBy;
	Country country;
		

	public Employee(int id, String name, String phoneno, String deptit, String status, Date createdDTm,
			String createdBy, Date updatedDTm, String updatedBy, Country country) {
		super();
		Id = id;
		Name = name;
		Phoneno = phoneno;
		Deptit = deptit;
		Status = status;
		CreatedDTm = createdDTm;
		CreatedBy = createdBy;
		UpdatedDTm = updatedDTm;
		UpdatedBy = updatedBy;
		this.country = country;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, String phoneno, String deptit, String status, Date createdDTm,
			String createdBy, Date updatedDTm, String updatedBy) {
		super();
		Id = id;
		Name = name;
		Phoneno = phoneno;
		Deptit = deptit;
		Status = status;
		CreatedDTm = createdDTm;
		CreatedBy = createdBy;
		UpdatedDTm = updatedDTm;
		UpdatedBy = updatedBy;
	}






	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhoneno() {
		return Phoneno;
	}

	public void setPhoneno(String phoneno) {
		Phoneno = phoneno;
	}

	public String getDeptit() {
		return Deptit;
	}

	public void setDeptit(String deptit) {
		Deptit = deptit;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Date getCreatedDTm() {
		return CreatedDTm;
	}

	public void setCreatedDTm(Date createdDTm) {
		CreatedDTm = createdDTm;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public Date getUpdatedDTm() {
		return UpdatedDTm;
	}

	public void setUpdatedDTm(Date updatedDTm) {
		UpdatedDTm = updatedDTm;
	}

	public String getUpdatedBy() {
		return UpdatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	
}
	