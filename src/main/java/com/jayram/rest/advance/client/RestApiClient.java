package com.jayram.rest.advance.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.jayram.rest.messenger.model.Message;

public class RestApiClient {

	public static void main(String args[]){
		
		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs/webapi/");
		WebTarget messageTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messageTarget.path("{messageId}");
		
		Message message = singleMessageTarget.resolveTemplate("messageId", "1") //Using Fluent API here i.e. chaining of methods one after other till we get object we want.
									.request(MediaType.APPLICATION_JSON)
									.get(Message.class); //For troubleshooting point of view, when getting error to convert stream to the specified instance of the class i.e at the time of trying to get object out of response(Unmarshalling), we can specify String.class so we can get actual payload to examine. 
		System.out.println(message.getMessage());
	}
}
