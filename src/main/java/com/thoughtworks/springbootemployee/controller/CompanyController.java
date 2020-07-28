package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/companies")
    public void addCompany(@RequestBody Company company){
        companyService.addCompany(company);
    }

    @DeleteMapping("/companies/{id}")
    public void deleteCompany(@PathVariable int id){
        companyService.deleteCompany(id);
    }

    @PutMapping("/companies")
    public Company updateCompany(Company company){
        return companyService.updateCompany(company);
    }

}
