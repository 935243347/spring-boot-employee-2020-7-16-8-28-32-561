package com.thoughtworks.springbootemployee.dao.impl;

import com.thoughtworks.springbootemployee.dao.EmployeeDao;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void deleteEmployee(int id) {
        Employee employeeReadyToDelete = employees.stream().filter(employee -> employee.getId() == id).findFirst().get();
        employees.remove(employeeReadyToDelete);
    }

    public Employee updateEmployee(Employee employee) {
        Employee employeeReadyToUpdate = employees.stream().filter(e -> e.getId() == employee.getId()).findFirst().orElse(null);
        employees.remove(employeeReadyToUpdate);
        employees.add(employee);
        return employeeReadyToUpdate;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Employee> getEmployeesByGender(String gender) {
        return employees.stream().filter(employee -> employee.getGender().equals(gender)).collect(Collectors.toList());
    }

    //todo extra a tool method or use springboot tool
    @Override
    public List<Employee> getEmployeesByPage(int page, int pageSize) {
        page = page <= 0 ? 1 : page;
        int fromIndex = (page - 1) * pageSize;
        if (fromIndex >= employees.size()) return null;
        if (employees.size() - fromIndex >= pageSize) {
            return employees.subList(fromIndex, fromIndex + pageSize);
        }
        return employees.subList(fromIndex, employees.size());
    }
}
