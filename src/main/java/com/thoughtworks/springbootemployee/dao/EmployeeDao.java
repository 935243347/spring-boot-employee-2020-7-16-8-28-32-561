package com.thoughtworks.springbootemployee.dao;

import com.thoughtworks.springbootemployee.entity.Employee;
import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee);
    void deleteEmployee(int id);
    Employee updateEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployee(int id);
    List<Employee> getEmployeesByGender(String gender);
}
