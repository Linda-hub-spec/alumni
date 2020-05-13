package com.system.Ijconnect.Alumni;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Path("/AlumniServices")
public class AlumniService {
	
	@PUT
	@Path("/alumni")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createAlumni(String body) {
		
		
		Response response = new Response();
		Alumni alumni = new Gson().fromJson(body, Alumni.class);
		Alumni data = new Alumni();
		data.setFirstname(alumni.getFirstname());
		data.setLastname(alumni.getLastname());
		data.setContactAddress(alumni.getContactAddress());
		data.setContactPhone(alumni.getContactPhone());
		data.setEmail(alumni.getEmail());
		data.setInYear(alumni.getInYear());
		data.setGraguatedYear(alumni.getGraguatedYear());
		data.setOccupation(alumni.getOccupation());
		data.setMaritalStatus(alumni.getMaritalStatus());
		
		AlumniDao dao = new AlumniDao();
		response = dao.saveAlumni(data);
		System.out.println("*** end of saveAlumni ***");
		String json = new Gson().toJson(response);
		
		return json;
		
	}
	

}
