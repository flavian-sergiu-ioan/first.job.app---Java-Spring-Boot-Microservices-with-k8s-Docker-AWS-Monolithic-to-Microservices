package com.example.first.job.app.job.service.impl;

import com.example.first.job.app.job.model.Job;
import com.example.first.job.app.job.repositories.JobRepository;
import com.example.first.job.app.job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobForUpdate = jobRepository.findById(id);
        if (jobForUpdate.isPresent()) {
            jobForUpdate.get().setLocation(updatedJob.getLocation());
            jobForUpdate.get().setTitle(updatedJob.getTitle());
            jobForUpdate.get().setDescription(updatedJob.getDescription());
            jobForUpdate.get().setMinSalary(updatedJob.getMinSalary());
            jobForUpdate.get().setMaxSalary(updatedJob.getMaxSalary());
            jobRepository.save(jobForUpdate.get());
            return true;
        }
        return false;
    }
}
