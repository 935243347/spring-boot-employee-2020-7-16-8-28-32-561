package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.dao.CompanyDao;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public void addCompany(Company company) {
        companyDao.addCompany(company);
    }

    @Override
    public void deleteCompany(int id) {
        companyDao.deleteCompany(id);
    }

    @Override
    public Company updateCompany(Company company) {
        return companyDao.updateCompany(company);
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
