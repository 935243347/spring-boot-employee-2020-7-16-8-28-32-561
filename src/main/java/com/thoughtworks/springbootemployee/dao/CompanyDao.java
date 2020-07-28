package com.thoughtworks.springbootemployee.dao;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;

import java.util.List;

public interface CompanyDao {
    void addCompany(Company company);

    void deleteCompany(int id);

    Company updateCompany(Company company);

    List<Company> getAllCompanies();

    Company getCompanyById(int id);

    List<Company> getCompanyByPage(int page, int pageSize);

    List<Employee> getAllEmployeeByCompanyId(int companyId);
}

