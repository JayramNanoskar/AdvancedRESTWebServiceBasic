package com.jayram.rest.advance;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/webapi") //Mapping to root URL
public class MyApp extends Application { //It tells Jersey that this is JAX-RS application. So this application looks at every resource in path.

}
