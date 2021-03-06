package com.system.Alumni.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.system.Alumni.Alumni;
import com.system.Alumni.AlumniDao;
import com.system.Alumni.AlumniLoginData;
import com.system.Alumni.Response;

@Path("/AlumniServices")
public class AlumniController {
	
	@POST
	@Path("/alumni")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createAlumni(String body) {
		
		Alumni alumni = new Gson().fromJson(body, Alumni.class);
		
		Response response = new Response();
		Alumni data = new Alumni();
		
		data.setFirstname(alumni.getFirstname());
		data.setLastname(alumni.getLastname());
		data.setInYear(alumni.getInYear());
		data.setGraduatedYear(alumni.getGraduatedYear());
		data.setOccupation(alumni.getOccupation());
		data.setMaritalStatus(alumni.getMaritalStatus());
		data.setEmail(alumni.getEmail());
		data.setContactAddress(alumni.getContactAddress());
		data.setContactPhone(alumni.getContactPhone());
		data.setUsername(alumni.getUsername());
		data.setPassword(alumni.getPassword());
			
		AlumniDao dao = new AlumniDao();
		response = dao.saveAlumni(data);
		System.out.println(response);
		System.out.println("*** end of saveAlumni ***");
		String json = new Gson().toJson(response);
		
		return json;
		
	}
	
	
	@POST
	@Path("/alumni/validate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String AlumniValidation(String body) {
		
		AlumniLoginData loginData = new Gson().fromJson(body, AlumniLoginData.class);
		AlumniLoginData data = new AlumniLoginData();
		
		data.setUsername(loginData.getUsername());
		data.setPassword(loginData.getPassword());
		
		AlumniDao dao = new AlumniDao();
		Response response = new Response();
		response = dao.validateAlumni(data);
		
		String json = new Gson().toJson(response);
		
		return json;
		
	}
	
	

}
