package com.homeprices.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquipSpaceDao {
	
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@aws-test.cdp1djvbas2k.us-east-1.rds.amazonaws.com:1521:ORCL";
	static final String USER = "myoracle";
	static final String PASS = "myoracle";
	
	static final String selectTableSQL = "SELECT EMPLOYEE_NUMBER,\r\n" + 
			"  EMPLOYEE_NAME,\r\n" + 
			"  OFFICE_LOCATION,\r\n" + 
			"  CUBE_LOCATION_REQUEST,\r\n" + 
			"  HARDWARE_EQUIPMENT_REQUEST,\r\n" + 
			"  ROOM_ALLOCATION\r\n" + 
			"FROM EQUIPMENT_SPACE_REQUEST";
	
	static final String INSERT_STRING = "INSERT\r\n" + 
			"INTO EQUIPMENT_SPACE_REQUEST\r\n" + 
			"  (\r\n" + 
			"    EMPLOYEE_NUMBER,\r\n" + 
			"    EMPLOYEE_NAME,\r\n" + 
			"    OFFICE_LOCATION,\r\n" + 
			"    CUBE_LOCATION_REQUEST,\r\n" + 
			"    HARDWARE_EQUIPMENT_REQUEST,\r\n" + 
			"    ROOM_ALLOCATION\r\n" + 
			"  )\r\n" + 
			"  VALUES\r\n" + 
			"  (\r\n" + 
			"    ?,\r\n" + 
			"    ?,\r\n" + 
			"    ?,\r\n" + 
			"    ?,\r\n" + 
			"    ?,\r\n" + 
			"    ?\r\n" + 
			"  )";
	
	public EquipSpaceDao() { }
	
	public List<EquipSpaceInfo> persist(EquipSpaceInfo req) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(INSERT_STRING);
			preparedStatement.setInt(1, req.getEmployeeId());
			preparedStatement.setString(2, req.getEmployeeName());
			preparedStatement.setString(3, req.getOfficeLocation());
			preparedStatement.setString(4, req.getCubeLocation());
			preparedStatement.setString(5, req.getHardwareEqip());
			preparedStatement.setString(6, req.getRoomAllocation());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		List<EquipSpaceInfo> list = getAllRows();
		return list;
	}
	
	public List<EquipSpaceInfo> getAllRows() {
		List<EquipSpaceInfo> list= new ArrayList<EquipSpaceInfo>();
		Connection dbConnection = getDBConnection();
		Statement statement = null;
		try {
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(selectTableSQL);
			EquipSpaceInfo req = null;
			while (rs.next()) {
				req = new EquipSpaceInfo();
				req.setEmployeeId(rs.getInt(1));
				req.setEmployeeName(rs.getString(2));
				req.setOfficeLocation(rs.getString(3));
				req.setCubeLocation(rs.getString(4));
				req.setHardwareEqip(rs.getString(5));
				req.setRoomAllocation(rs.getString(6));
				list.add(req);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		try {
			dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
			return dbConnection;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return dbConnection;

	}
	
}
