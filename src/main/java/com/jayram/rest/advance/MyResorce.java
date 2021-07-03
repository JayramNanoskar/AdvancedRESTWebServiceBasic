package com.jayram.rest.advance;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Singleton
public class MyResorce {

	private int count;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod(){
		return "It works!";
	}
	
	@GET
	@Path("/date")
	@Produces(MediaType.TEXT_PLAIN)
	public Date getDate(){
		return Calendar.getInstance().getTime();
	}
	
	@GET
	@Path("/count")
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod2(){ //Default resource instance scope is Request scope, but we can change it to Singleton resource scope. So JAX-RS held on that same resource instance for every request till server is running.
		count = count + 1;
		return "It works! This method was called "+count+ " time(s)";
	}
}

