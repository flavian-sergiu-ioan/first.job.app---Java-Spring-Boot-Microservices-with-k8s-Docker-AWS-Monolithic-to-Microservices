package com.example.first.job.app.job.service.impl;

import com.example.first.job.app.job.model.Job;
import com.example.first.job.app.job.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
       jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobs.stream().filter(job -> Objects.equals(job.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        Job job = getJobById(id);
        if (job != null) {
            jobs.remove(job);
            return true;
        }
        return false;
    }
}
