package com.example.courseworkwithlist.service;

import com.example.courseworkwithlist.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName);

    Employee removeEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);
    Collection<Employee> all();

}
