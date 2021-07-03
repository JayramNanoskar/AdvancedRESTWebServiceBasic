package com.jayram.rest.advance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/test")
public class MySecondResource {
	
	@PathParam("pathParam") private String pathParamExample; //We can apply @PathParam on member variables also. But we can apply these param annotations on member variables only when resource is not singleton.
	@QueryParam("query") private String queryParamExample;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod(){
		return "It works! Path param used: "+pathParamExample+ " Query param used: "+queryParamExample;
	}
}
