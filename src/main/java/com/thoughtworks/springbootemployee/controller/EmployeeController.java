package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public void addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/employees")
    public Employee updateEmployees(Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployeesByCondition(
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (gender != null) {
            return employeeService.getEmployeesByGender(gender);
        }
        if (page != null && pageSize != null) {
            return employeeService.getEmployeesByPage(page, pageSize);
        }
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

}
