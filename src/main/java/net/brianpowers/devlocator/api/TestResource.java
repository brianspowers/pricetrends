package net.brianpowers.devlocator.api;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by bpowers on 5/9/15.
 */
@Component
@Path("/health")
public class TestResource {

    @GET
    @Produces("application/json")
    public String health() {
        return new String("Jersey: Up and Running!");
    }
}
