package com.xiao.jersey;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/jersey")
public class Endpoint {

    @GET
    public String message() {
        return "Hello";
    }

}
