package com.amazonaws.lambda.demo;

import java.io.Serializable;
import java.sql.Date;

public class AccountCreation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public int employeeId;
	
	public String employeeName;
	
	public String dateOfHire;
	
	public String employeeContactDetails;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	

	public String getDateOfHire() {
		return dateOfHire;
	}

	public void setDateOfHire(String dateOfHire) {
		this.dateOfHire = dateOfHire;
	}

	public String getEmployeeContactDetails() {
		return employeeContactDetails;
	}

	public void setEmployeeContactDetails(String employeeContactDetails) {
		this.employeeContactDetails = employeeContactDetails;
	}
	
	
	
}
