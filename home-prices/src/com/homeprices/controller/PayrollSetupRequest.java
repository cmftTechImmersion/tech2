package com.homeprices.controller;

import java.io.Serializable;

public class PayrollSetupRequest implements Serializable {
	private static final long serialVersionUID = 8325937067837905264L;
	
	private String accountNumber;
    private String routingAccountNumber;
    private String ssn;
    private String bankName;
    private String typeOfAccount;
    private String employeeName;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getRoutingAccountNumber() {
		return routingAccountNumber;
	}
	public void setRoutingAccountNumber(String routingAccountNumber) {
		this.routingAccountNumber = routingAccountNumber;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getTypeOfAccount() {
		return typeOfAccount;
	}
	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	
	
	
	
}
