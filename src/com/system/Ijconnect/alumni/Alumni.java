package com.system.Ijconnect.Alumni;

public class Alumni {
	
	private String firstname;
	private String lastname;
	private String graguatedYear;
	private String inYear;
	private String occupation;
	private String maritalStatus;
	private String email;
	private String contactAddress;
	private String contactPhone;
	
	public Alumni() {
		
	}
	
	public Alumni(String firstname, String lastname, String graguatedYear, String inYear, String occupation,
			String maritalStatus, String email, String contactAddress, String contactPhone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.graguatedYear = graguatedYear;
		this.inYear = inYear;
		this.occupation = occupation;
		this.maritalStatus = maritalStatus;
		this.email = email;
		this.contactAddress = contactAddress;
		this.contactPhone = contactPhone;
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
	
	public String getGraguatedYear() {
		return graguatedYear;
	}
	
	public void setGraguatedYear(String graguatedYear) {
		this.graguatedYear = graguatedYear;
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

}
