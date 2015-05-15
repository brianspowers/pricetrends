package net.brianpowers.blsviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BlsDataViewerApplication extends SpringBootServletInitializer {

    /**
     * Explicitly declaring this Bean here so that we can inject it into our service client, and can mock it in tests.
     *
     * @return
     */
    @Bean
    @Scope("prototype")
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    public static void main(String[] args) {
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        System.setProperty("server.port", webPort);
        SpringApplication.run(BlsDataViewerApplication.class, args);
    }
}
