package com.system.Alumni;

public class Alumni {
	
	private int alumniId;
	private String firstname;
	private String lastname;
	private String graduatedYear;
	private String inYear;
	private String occupation;
	private String maritalStatus;
	private String email;
	private String contactAddress;
	private String contactPhone;
	private String username;
	private String password;
	
	public Alumni() {
		
	}
	
	public Alumni(int alumniId, String firstname, String lastname, String graduatedYear, String inYear, String occupation,
			String maritalStatus, String email, String contactAddress, String contactPhone, String username, String password) {
		super();
		this.alumniId = alumniId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.graduatedYear = graduatedYear;
		this.inYear = inYear;
		this.occupation = occupation;
		this.maritalStatus = maritalStatus;
		this.email = email;
		this.contactAddress = contactAddress;
		this.contactPhone = contactPhone;
		this.username = username;
		this.password = password;
	}
	
	public int getAlumniId() {
		return alumniId;
	}

	public void setAlumniId(int alumniId) {
		
		this.alumniId = alumniId;
	}

	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getGraduatedYear() {
		return graduatedYear;
	}
	
	public void setGraduatedYear(String graduatedYear) {
		this.graduatedYear = graduatedYear;
	}
	
	public String getInYear() {
		return inYear;
	}
	
	public void setInYear(String inYear) {
		this.inYear = inYear;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String getMaritalStatus() {
		return maritalStatus;
	}
	
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContactAddress() {
		return contactAddress;
	}
	
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	
	public String getContactPhone() {
		return contactPhone;
	}
	
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
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

}
