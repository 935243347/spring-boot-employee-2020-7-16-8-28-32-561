package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.dao.EmployeeDao;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    public void addEmployee(Employee employee){
        employeeDao.addEmployee(employee);
    }
    public void deleteEmployee(int id){
        employeeDao.deleteEmployee(id);
    }
    public Employee updateEmployee(Employee employee){
        return employeeDao.updateEmployee(employee);
    }
    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }
    public Employee getEmployee(int id){
        return employeeDao.getEmployee(id);
    }

    @Override
    public List<Employee> getEmployeesByGender(String gender) {
        return employeeDao.getEmployeesByGender(gender);
    }
}
