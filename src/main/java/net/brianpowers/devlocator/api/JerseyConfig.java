package net.brianpowers.devlocator.api;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * Jersey web service configuration.
 *
 * We'll look in net.brianpowers.devlocator.api for resources.
 *
 * All endpoints will be mounted starting at /api
 */
@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("net.brianpowers.devlocator.api");
    }
}