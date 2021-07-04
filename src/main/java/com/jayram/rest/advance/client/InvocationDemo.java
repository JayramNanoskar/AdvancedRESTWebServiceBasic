package com.jayram.rest.advance.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvocationDemo {

	public static void main(String[] args) {
		
		InvocationDemo invocationDemo = new InvocationDemo();
		Invocation invocation = invocationDemo.prepareRequestForMessagesByYear(2021);
		Response response = invocation.invoke(); //Making actual request
		System.out.println(response.getStatus());
	}

	public Invocation prepareRequestForMessagesByYear(int year) {
		Client client = ClientBuilder.newClient();
		
		Invocation buildGet = client.target("http://localhost:8080/advanced-jaxrs/webapi/")
										.path("messages")
										.queryParam("year", year)
										.request(MediaType.APPLICATION_JSON)
										.buildGet(); //Getting Invocation object which is request that ready to go.
		return buildGet;
	}

}
