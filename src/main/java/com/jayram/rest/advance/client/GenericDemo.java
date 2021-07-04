package com.jayram.rest.advance.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.jayram.rest.messenger.model.Message;

public class GenericDemo {

	public static void main(String[] args) {


		Client client = ClientBuilder.newClient();
		
		List<Message> response = client.target("http://localhost:8080/advanced-jaxrs/webapi/")
										.path("messages")
										.queryParam("year", 2021)
										.request(MediaType.APPLICATION_JSON)
										.get(new GenericType<List<Message>>(){}); //Providing inline implementation
		System.out.println(response);
	}

}
