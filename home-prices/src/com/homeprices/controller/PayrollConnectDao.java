package com.homeprices.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PayrollConnectDao {
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@aws-test.cdp1djvbas2k.us-east-1.rds.amazonaws.com:1521:ORCL";
	static final String USER = "myoracle";
	static final String PASS = "myoracle";
	static final String selectTableSQL = "SELECT EMPLOYEE_NAME,\r\n" + 
			"  SSN,\r\n" + 
			"  BANK_NAME,\r\n" + 
			"  ROUTING_ACCOUNT,\r\n" + 
			"  ACC_NUMBER,\r\n" + 
			"  TYPE_OF_ACCOUNT\r\n" + 
			"FROM PAYROLL_SETUP";
	
	
	static final String INSERT_STRING = "INSERT\r\n" + "INTO PAYROLL_SETUP\r\n" + "  (\r\n" + "    EMPLOYEE_NAME,\r\n"
			+ "    SSN,\r\n" + "    BANK_NAME,\r\n" + "    ROUTING_ACCOUNT,\r\n" + "    ACC_NUMBER,\r\n"
			+ "    TYPE_OF_ACCOUNT\r\n" + "  )\r\n" + "  VALUES\r\n" + "  (\r\n" + "    ?,\r\n" + "    ?,\r\n"
			+ "    ?,\r\n" + "    ?,\r\n" + "    ?,\r\n" + "    ?\r\n" + "  )";

	public PayrollConnectDao() {
	}
	
	public List<PayrollSetupRequest> persist(PayrollSetupRequest req) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(INSERT_STRING);
			preparedStatement.setString(1, req.getEmployeeName());
			preparedStatement.setString(2, req.getSsn());
			preparedStatement.setString(3, req.getBankName());
			preparedStatement.setString(4, req.getRoutingAccountNumber());
			preparedStatement.setString(5, req.getAccountNumber());
			preparedStatement.setString(6, req.getTypeOfAccount());
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
		
		List<PayrollSetupRequest> list = getAllRows();
		return list;
	}
	
	public List<PayrollSetupRequest> getAllRows() {
		List<PayrollSetupRequest> list= new ArrayList<PayrollSetupRequest>();
		Connection dbConnection = getDBConnection();
		Statement statement = null;
		try {
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(selectTableSQL);
			PayrollSetupRequest req = null;
			while (rs.next()) {
				req = new PayrollSetupRequest();
				req.setEmployeeName(rs.getString(1));
				req.setSsn(rs.getString(2));
				req.setBankName(rs.getString(3));
				req.setRoutingAccountNumber(rs.getString(4));
				req.setAccountNumber(rs.getString(5));
				req.setTypeOfAccount(rs.getString(6));
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
