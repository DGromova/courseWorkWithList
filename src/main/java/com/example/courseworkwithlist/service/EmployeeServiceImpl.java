package com.example.courseworkwithlist.service;

import com.example.courseworkwithlist.Employee;
import com.example.courseworkwithlist.exceptions.EmployeeAlreadyAddedException;
import com.example.courseworkwithlist.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//    Employee [] employees = new Employee[5];

    List<Employee> employee = new ArrayList<>();
    // Данные о сотрудниках
//    Employee employee1 = new Employee ("Иванов", "Иван");
//    Employee employee2 = new Employee("Макаров", "Владимир");
//    Employee employee3 = new Employee("Исаев", "Матвей");
//    Employee employee4 = new Employee("Лаптев", "Даниил");
    @Override
    public Employee addEmployee(String lastName, String firstName) throws RuntimeException {
        Employee newEmployee = new Employee(lastName, firstName);
        if (employee.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже есть в списке");
        } else {
            employee.add(newEmployee);
            return newEmployee;
        }
    }
    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        Employee removingEmployee = new Employee(lastName, firstName);
        if (employee.contains(removingEmployee)) {
            employee.remove(removingEmployee);
            return removingEmployee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник " + removingEmployee + " не найден");
        }
    }
    @Override
    public Employee findEmployee(String lastName, String firstName) {
        Employee searchingEmployee = new Employee(lastName, firstName);
        if (employee.contains(searchingEmployee)) {
            return searchingEmployee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник " + searchingEmployee + " не найден");
        }
    }
    @Override
    public Collection<Employee> all() {
        return Collections.unmodifiableList(employee);
    }
}
