package com.example.first.job.app.job.model;

import lombok.Data;

@Data
public class Job {
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
}
