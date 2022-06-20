package com.example.new_app_students.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userAssigned;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;

    private String description;

    private String color;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Task() {
    }

    public Task(Long id, String userAssigned, String description, String color, Person person) {
        this.id = id;
        this.userAssigned = userAssigned;
        this.deadline = deadline;
        this.description = description;
        this.color = color;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserAssigned() {
        return userAssigned;
    }

    public void setUserAssigned(String userAssigned) {
        this.userAssigned = userAssigned;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
