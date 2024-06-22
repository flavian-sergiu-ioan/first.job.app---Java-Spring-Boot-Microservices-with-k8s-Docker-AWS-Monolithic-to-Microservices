package com.example.first.job.app.job.service;


import com.example.first.job.app.job.model.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(Long id);
    boolean deleteJobById(Long id);
}
