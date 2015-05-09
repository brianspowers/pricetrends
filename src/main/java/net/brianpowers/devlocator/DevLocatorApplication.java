package net.brianpowers.devlocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class DevLocatorApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DevLocatorApplication.class, args);
    }
}