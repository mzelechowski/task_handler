package com.malarska.taskshandler.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="tasks")
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @Column(nullable = true)
    private LocalDateTime endDate;

    @Column(nullable = true)
    private double breaklength;

    @Column(nullable = false)
    private boolean completed;

    @Column(nullable = true)
    private boolean again;

    public Task(String name, LocalDateTime startDate, double breaklength, boolean completed, boolean again) {
        this.name = name;
        this.startDate = startDate;
        this.breaklength = breaklength;
        this.completed = completed;
        this.again = again;
    }
}