package com.system.Ijconnect.Alumni;

public class AlumniLoginData {
	
	private String username;
	private String password;
	private String alumniId;
	
	public AlumniLoginData() {
		
	}
	public AlumniLoginData(String username, String password, String alumniId) {
		super();
		this.username = username;
		this.password = password;
		this.alumniId = alumniId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAlumniId() {
		return alumniId;
	}
	public void setAlumniId(String alumniId) {
		this.alumniId = alumniId;
	}

}
