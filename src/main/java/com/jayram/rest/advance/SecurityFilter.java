package com.jayram.rest.advance;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.commons.codec.binary.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter{

	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic";
	private static final String SECURED_URL_PREFIX = "secured";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)){
			
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER);
			
			if(authHeader != null && authHeader.size() > 0){
				
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodedString = new String(Base64.decodeBase64(authToken.getBytes()));
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				
				if("user".equals(username) && "password".equals(password)){ //Consider, Authorized user name is user and password is password for accessing secured resource API
					return; //Proceeding this request
				}
				
			}
			Response unautorizedStatus = Response.status(Response.Status.UNAUTHORIZED).entity("User cannot access the resource.").build();
			requestContext.abortWith(unautorizedStatus); //Aborting this request.
		}
	}

	
}
