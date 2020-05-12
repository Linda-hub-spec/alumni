package com.system.Ijconnect.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.system.Ijconnect.connection.DbConnection;

public class UserDao {
	
	Connection conn = null;
	PreparedStatement statement = null;
	ResultSet result = null;
	UserResponse response = null;
	String sql = null;
	String NOTIFY_SUCCESS_MESSAGE = "Alumni added Successfully!!!";
	String NOTIFY_FAILURE_MESSAGE = "Alumni Failed!";
	int NOTIFY_SUCCESS_CODE = 200;
	int NOTIFY_FAILURE_CODE = 404;
	
	//add new user
	public UserResponse saveUser(Users user) {
		DbConnection dbConnection = new DbConnection ();
		
		try {
			
			conn = dbConnection.Dbconnection();
			sql = "INSERT INTO alumni (firstname,lastname,inyear,graduatedyear,occupation,maritalstatus,email,contactaddress,contactphone) values (?,?,?,?,?,?,?,?,?)";
			statement = conn.prepareStatement(sql);
			
			statement.setString(1, user.getFirstname());
			statement.setString(2, user.getLastname());
			statement.setString(3, user.getInYear());
			statement.setString(4, user.getGraguatedYear());
			statement.setString(5, user.getOccupation());
			statement.setString(6, user.getMaritalStatus());
			statement.setString(7, user.getEmail());
			statement.setString(8, user.getContactAddress());
			statement.setString(9, user.getContactPhone());
			
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
	
	//update existing user
	public UserResponse updateUser(Users user) {
		
		
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	//delete user
	public UserResponse deleteUser(Users user) {
		
		try {
					
			}catch(Exception e) {
				e.printStackTrace();
			}
			return response; 
	}

}
