package com.amazonaws.lambda.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountCreationDao {
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@aws-test.cdp1djvbas2k.us-east-1.rds.amazonaws.com:1521:ORCL";
	static final String USER = "myoracle";
	static final String PASS = "myoracle";
	static final String selectTableSQL = "SELECT EMPLOYEE_ID,\r\n" + 
			"  EMPLOYEE_NAME,\r\n" + 
			"  DATE_OF_HIRE,\r\n" + 
			"  EMPLOYEE_CONTACT_DETAILS\r\n" + 
			"FROM AC_CREATION";
	
	
	static final String INSERT_STRING = "INSERT\r\n" + 
			"INTO AC_CREATION\r\n" + 
			"  (\r\n" + 
			"    EMPLOYEE_ID,\r\n" + 
			"    EMPLOYEE_NAME,\r\n" + 
			"    DATE_OF_HIRE,\r\n" + 
			"    EMPLOYEE_CONTACT_DETAILS\r\n" + 
			"  )\r\n" + 
			"  VALUES\r\n" + 
			"  (\r\n" + 
			"    ?,\r\n" + 
			"    ?,\r\n" + 
			"    TO_DATE(?, 'mm/dd/yyyy'),\r\n" + 
			"    ?\r\n" + 
			"  )";

	public AccountCreationDao() {
	}
	
	public List<AccountCreation> persist(AccountCreation req) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(INSERT_STRING);
			preparedStatement.setInt(1, req.getEmployeeId());
			preparedStatement.setString(2, req.getEmployeeName());
			preparedStatement.setString(3, req.getDateOfHire());
			preparedStatement.setString(4, req.getEmployeeContactDetails());
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
		
		List<AccountCreation> list = getAllRows();
		return list;
	}
	
	public List<AccountCreation> getAllRows() {
		List<AccountCreation> list= new ArrayList<AccountCreation>();
		Connection dbConnection = getDBConnection();
		Statement statement = null;
		try {
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(selectTableSQL);
			AccountCreation req = null;
			while (rs.next()) {
				req = new AccountCreation();
				req.setEmployeeId(rs.getInt(1));
				req.setEmployeeName(rs.getString(2));
				req.setDateOfHire(rs.getString(3));
				req.setEmployeeContactDetails(rs.getString(4));
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
