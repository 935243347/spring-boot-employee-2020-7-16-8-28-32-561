package com.thoughtworks.springbootemployee.dao.impl;

import com.thoughtworks.springbootemployee.dao.CompanyDao;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyDaoImpl implements CompanyDao {

    private final List<Company> companies = new ArrayList<>();

    @Override
    public void addCompany(Company company) {
        companies.add(company);
    }

    @Override
    public void deleteCompany(int id) {
        Company companyReadyToDelete = companies.stream().filter(company -> company.getId() == id).findFirst().get();
        companies.remove(companyReadyToDelete);
    }

    @Override
    public Company updateCompany(Company company) {
        Company companyReadyToUpdate = companies.stream().filter(e -> e.getId() == company.getId()).findFirst().orElse(null);
        companies.remove(companyReadyToUpdate);
        companies.add(company);
        return companyReadyToUpdate;
    }

    @Override
    public List<Company> getAllCompanies() {
        return null;
    }

    @Override
    public Company getCompanyById(int id) {
        return null;
    }

    @Override
    public List<Company> getCompanyByPage(int page, int pageSize) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployeeByCompanyId(int companyId) {
        return null;
    }
}
