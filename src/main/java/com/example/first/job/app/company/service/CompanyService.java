package com.example.first.job.app.company.service;

import com.example.first.job.app.company.model.Company;

import java.util.List;


public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Company company, Long id);
    void createCompany(Company company);
    boolean deleteCompanyById(Long id);
    Company getCompanyById(Long id);
}
