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
	String NOTIFY_SUCCESS_MESSAGE = "Alumni  Successfully!!!";
	String NOTIFY_FAILURE_MESSAGE = "Alumni Failed!";
	String NOTIFY_FAILURE_MESSAGE_02 = "Alumni Does not Exist!";
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
			sql = "INSERT INTO alumni (firstname,lastname,inyear,graduatedyear,"
					+ "occupation,maritalstatus,email,contactaddress,contactphone,username,password) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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
			preparedStatement.setString(10, user.getUsername());
			preparedStatement.setString(11, user.getPassword());
			
			Boolean resultKey = preparedStatement.execute();
			 
			//if (resultKey != false) {
				
			response.setStatusCode(NOTIFY_SUCCESS_CODE);
			response.setStatusMessage(NOTIFY_SUCCESS_MESSAGE);
			//System.out.println(response.getStatusCode() +  response.getStatusMessage());
			
			///}
			return response;
			
		}catch(SQLException e) {
			e.printStackTrace();
			response.setStatusCode(NOTIFY_FAILURE_CODE);
			response.setStatusMessage(NOTIFY_FAILURE_MESSAGE);
			return response;
		}	
		
		
	}
	
	
	/*public static void main(String [] args) {
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
	}*/
	
	
	
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
	
	//validate login
	public Response validateAlumni(AlumniLoginData user) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Response response = new Response();
		
		try {
			
			DbConnection dbConnection = new DbConnection ();
			conn = dbConnection.getConnection();
			sql = "SELECT * FROM alumni WHERE username = ? AND password = ? ";
		
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			
			result = preparedStatement.executeQuery();
			if (result.next()) {
				
				response.setStatusCode(NOTIFY_SUCCESS_CODE);
				response.setStatusMessage(NOTIFY_SUCCESS_MESSAGE);
				return response;
			}else {
				
				response.setStatusCode(NOTIFY_FAILURE_CODE);
				response.setStatusMessage(NOTIFY_FAILURE_MESSAGE_02);
				return response;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			response.setStatusCode(NOTIFY_FAILURE_CODE);
			response.setStatusMessage(NOTIFY_FAILURE_MESSAGE);
			return response;
		}
		
		
			
	}
	
	
}
