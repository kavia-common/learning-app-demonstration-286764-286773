package com.example.demo.config;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Seeds in-memory database with sample Course data at startup.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final CourseRepository courseRepository;

    public DataInitializer(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) {
        if (courseRepository.count() > 0) {
            return;
        }

        courseRepository.saveAll(List.of(
                new Course("Spring Boot Fundamentals",
                        "Learn the basics of Spring Boot to build modern Java applications.",
                        "Beginner", 6),
                new Course("Thymeleaf Essentials",
                        "Build server-rendered UIs with Thymeleaf and Spring MVC.",
                        "Beginner", 4),
                new Course("RESTful APIs with Spring",
                        "Design and implement RESTful APIs with Spring Web and Springdoc.",
                        "Intermediate", 5),
                new Course("Data JPA with H2",
                        "Persist data using Spring Data JPA and the in-memory H2 database.",
                        "Intermediate", 3),
                new Course("Deploying Spring Apps",
                        "Best practices for packaging and deploying Spring Boot applications.",
                        "Advanced", 4)
        ));
    }
}
