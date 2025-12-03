package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Learning App demonstration.
 */
@SpringBootApplication
public class LearningAppApplication {

    // PUBLIC_INTERFACE
    /**
     * Bootstraps the Spring Boot application.
     * @param args CLI arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(LearningAppApplication.class, args);
    }
}
