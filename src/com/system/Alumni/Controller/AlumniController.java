package com.system.Alumni.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.system.Alumni.Alumni;
import com.system.Alumni.AlumniDao;
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
			
		AlumniDao dao = new AlumniDao();
		response = dao.saveAlumni(data);
		System.out.println(response);
		System.out.println("*** end of saveAlumni ***");
		String json = new Gson().toJson(response);
		
		return json;
		
	}
	

}
