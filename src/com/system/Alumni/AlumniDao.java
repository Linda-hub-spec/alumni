package com.system.Alumni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.system.connection.DbConnection;

public class AlumniDao {
	
	Connection conn = null;
	PreparedStatement statement = null;
	ResultSet result = null;
	Response response = null;
	String sql = null;
	String NOTIFY_SUCCESS_MESSAGE = "Alumni added Successfully!!!";
	String NOTIFY_FAILURE_MESSAGE = "Alumni Failed!";
	int NOTIFY_SUCCESS_CODE = 200;
	int NOTIFY_FAILURE_CODE = 404;
	
	
	//add new user
	public Response saveAlumni(Alumni user) {
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		//ResultSet result = null;
		Response response = new Response();
		System.out.println("**** in saveAlumni ****");
	
		try {
			DbConnection dbConnection = new DbConnection ();
			conn = dbConnection.getConnection();
			System.out.println("***** database connected *****");
			sql = "INSERT INTO alumni (firstname,lastname,inyear,graduatedyear,occupation,maritalstatus,email,contactaddress,contactphone) VALUES (?,?,?,?,?,?,?,?,?)";
			preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getInYear());
			preparedStatement.setString(4, user.getGraduatedYear());
			preparedStatement.setString(5, user.getOccupation());
			preparedStatement.setString(6, user.getMaritalStatus());
			preparedStatement.setString(7, user.getEmail());
			preparedStatement.setString(8, user.getContactAddress());
			preparedStatement.setString(9, user.getContactPhone());
			
			Boolean resultKey = preparedStatement.execute();
			 
			if (resultKey != false) {
				
			response.setStatusCode(NOTIFY_SUCCESS_CODE);
			response.setStatusMessage(NOTIFY_SUCCESS_MESSAGE);
			
			}
			return response;
			
		}catch(SQLException e) {
			e.printStackTrace();
			response.setStatusCode(NOTIFY_FAILURE_CODE);
			response.setStatusMessage(NOTIFY_FAILURE_MESSAGE);
			return response;
		}	
		
		
	}
	
	
	public static void main(String [] args) {
		Alumni user = new Alumni();
		user.setFirstname("wisdom");
		user.setLastname("peter");
		user.setInYear("2003");
		user.setGraduatedYear("2009");
		user.setOccupation("Software Developer");
		user.setMaritalStatus("Single");
		user.setEmail("roberstone@gmail.com");
		user.setContactAddress("ikeja");
		user.setContactPhone("08029381745");
		Response response = new Response();
		response = new AlumniDao().saveAlumni(user);
		System.out.println(response);
	}
	
	//add login details
	public Response saveLoginData(AlumniLoginData user) {
		
		DbConnection dbConnection = new DbConnection ();
		conn = dbConnection.getConnection();
		sql = "INSERT INTO alumnilogin (alimniId, username, password) values (?,?,?)";
		try {
			
			statement = conn.prepareStatement(sql);
			statement.setString(1, user.getAlumniId());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			result = statement.executeQuery();
			response.setStatusCode(NOTIFY_SUCCESS_CODE);
			response.setStatusMessage(NOTIFY_SUCCESS_MESSAGE);
			return response;
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.setStatusCode(NOTIFY_FAILURE_CODE);
			response.setStatusMessage(NOTIFY_FAILURE_MESSAGE);
			return response;
		}
		
	}
	
	//update existing ALUMNI
	// you get the alumniId from login table using the username and password
	// fetch the alumni data  using the retrieved id
	public Response updateAlumni(Alumni user, String id) {
		
	
		try {
			DbConnection dbConnection = new DbConnection ();
			conn = dbConnection.getConnection();
			sql = "UPDATE alumni "
					+ "SET firstname = ?,lastname = ?,inyear = ?,"
					+ "graduatedyear = ?,occupation = ?,maritalstatus = ?,"
					+ "email = ?,contactaddress = ?,contactphone = ?"
					+ "WHERE alumniId = ?";
			
			statement = conn.prepareStatement(sql);
			statement.setString(1, user.getFirstname() );
			statement.setString(2, user.getLastname() );
			statement.setString(3, user.getInYear() );
			statement.setString(4, user.getGraduatedYear() );
			statement.setString(5, user.getOccupation() );
			statement.setString(6, user.getMaritalStatus());
			statement.setString(7, user.getEmail() );
			statement.setString(8, user.getContactAddress() );
			statement.setString(9, user.getContactPhone() );
			statement.setString(10, id );
			
			result = statement.executeQuery();
			response.setStatusCode(NOTIFY_SUCCESS_CODE);
			response.setStatusMessage(NOTIFY_SUCCESS_MESSAGE);
			return response;
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatusCode(NOTIFY_FAILURE_CODE);
			response.setStatusMessage(NOTIFY_FAILURE_MESSAGE);
			return response;
		}
		
	}
	
	//delete user
	public Response deleteUser(Alumni user) {
		
		try {
					
			}catch(Exception e) {
				e.printStackTrace();
			}
			return response; 
	}
	
	
}
