package com.homeprices.controller;

import java.io.Serializable;

public class EquipSpaceInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public int employeeId;
	
	public String employeeName;
	
	public String officeLocation;
	
	public String cubeLocation;
	
	public String hardwareEqip;
	
	public String roomAllocation;

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

	public String getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}

	public String getCubeLocation() {
		return cubeLocation;
	}

	public void setCubeLocation(String cubeLocation) {
		this.cubeLocation = cubeLocation;
	}

	public String getHardwareEqip() {
		return hardwareEqip;
	}

	public void setHardwareEqip(String hardwareEqip) {
		this.hardwareEqip = hardwareEqip;
	}

	public String getRoomAllocation() {
		return roomAllocation;
	}

	public void setRoomAllocation(String roomAllocation) {
		this.roomAllocation = roomAllocation;
	}
	
	
	
}
