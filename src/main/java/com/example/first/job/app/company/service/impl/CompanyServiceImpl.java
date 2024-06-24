package com.example.first.job.app.company.service.impl;

import com.example.first.job.app.company.model.Company;
import com.example.first.job.app.company.repository.CompanyRespository;
import com.example.first.job.app.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRespository companyRespository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRespository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyToUpdate = companyRespository.findById(id);
        if (companyToUpdate.isPresent()) {
            companyToUpdate.get().setDescription(company.getDescription());
            companyToUpdate.get().setName(company.getName());
            companyToUpdate.get().setJobs(company.getJobs());
            companyRespository.save(companyToUpdate.get());
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRespository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try {
            companyRespository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRespository.findById(id).orElse(null);
    }
}
