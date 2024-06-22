package com.example.first.job.app.job.controller;


import com.example.first.job.app.job.model.Job;
import com.example.first.job.app.job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll() {
       return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable("id") Long id) {
        Job job = jobService.getJobById(id);
        if (job != null) {
            return ResponseEntity.ok(job);
        } else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/job/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id") Long id) {
        boolean deleted = jobService.deleteJobById(id);
        if(deleted) {
            return new ResponseEntity<>("Job Deleted successfully", HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
