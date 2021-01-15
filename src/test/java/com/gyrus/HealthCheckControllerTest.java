package com.gyrus;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HealthCheckControllerTest {

    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void testHealth() {
        ResponseEntity<Health> response = restTemplate.getForEntity("http://localhost:8080/actuator/health", Health.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Health.UP, response.getBody());
    }
}
