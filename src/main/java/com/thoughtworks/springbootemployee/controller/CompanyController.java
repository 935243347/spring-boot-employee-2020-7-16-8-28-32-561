package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/companies")
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @DeleteMapping("/companies/{id}")
    public void deleteCompany(@PathVariable int id) {
        companyService.deleteCompany(id);
    }

    @PutMapping("/companies")
    public Company updateCompany(Company company) {
        return companyService.updateCompany(company);
    }

    @GetMapping("/companies")
    public List<Company> getCompanyByCondition(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (page != null && pageSize != null) {
            return companyService.getCompanyByPage(page, pageSize);
        }
        return companyService.getAllCompanies();
    }

    @GetMapping("/companies/{id}/employees")
    public List<Employee> getAllEmployeeByCompanyId(@PathVariable int id){
        return companyService.getAllEmployeeByCompanyId(id);
    }

    @GetMapping("/companies/{id}")
    public Company getCompanyById(@PathVariable int id){
        return companyService.getCompanyById(id);
    }

}
