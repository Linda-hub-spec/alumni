package com.system.Ijconnect.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbConnection {
	
	private static Connection con = null;
	private static String USERNAME = "root";
	private static String PASSWORD = "";
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/ij_connect?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false&serverTimezone=UTC";
	
	
	public Connection Dbconnection() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("----- Database connected -----");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("----- Database connection failed -----");
		}
		return null;
	}

}
