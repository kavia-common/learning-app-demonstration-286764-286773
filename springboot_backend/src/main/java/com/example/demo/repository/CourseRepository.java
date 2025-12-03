package com.example.demo.repository;

import com.example.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Courses.
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
}
