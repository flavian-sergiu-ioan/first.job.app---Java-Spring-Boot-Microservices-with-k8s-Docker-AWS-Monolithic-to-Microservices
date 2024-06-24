package com.example.first.job.app.company.repository;

import com.example.first.job.app.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRespository extends JpaRepository<Company, Long> {
}
