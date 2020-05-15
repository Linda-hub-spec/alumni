package com.system.connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection {
	
	private static Connection con ;
	private static String USERNAME = "root";
	private static String PASSWORD = "";
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/ij_connect?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false&serverTimezone=UTC";
	
	
	public Connection getConnection() {
		try {
			System.out.println("**** in dbConnection class ****");
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			if (con != null) {
				System.out.println("----- Database connected -----");
			}
			return con;
			
		}catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("----- Database connection failed -----");
			return null;
		}
		
	}
	
	/*public static void main(String [] args) {
		//Connection con = null ;
		//con= getConnection();
		System.out.println(new DbConnection().getConnection());
		//System.out.println(con);
	}*/

}
