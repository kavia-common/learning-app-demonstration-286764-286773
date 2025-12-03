package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Course represents a learning resource in the demo catalog.
 */
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    private String level;

    private int durationHours;

    private LocalDateTime createdAt;

    public Course() {
        // default constructor for JPA
    }

    public Course(String title, String description, String level, int durationHours) {
        this.title = title;
        this.description = description;
        this.level = level;
        this.durationHours = durationHours;
    }

    @PrePersist
    public void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description; }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) { this.level = level; }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) { this.durationHours = durationHours; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
