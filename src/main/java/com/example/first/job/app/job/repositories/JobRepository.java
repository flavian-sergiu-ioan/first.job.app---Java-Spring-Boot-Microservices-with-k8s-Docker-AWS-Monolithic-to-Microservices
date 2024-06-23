package com.example.first.job.app.job.repositories;

import com.example.first.job.app.job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
