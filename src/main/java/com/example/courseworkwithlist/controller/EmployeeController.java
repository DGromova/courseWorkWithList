package com.example.courseworkwithlist.controller;

import com.example.courseworkwithlist.Employee;
import com.example.courseworkwithlist.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee add(@RequestParam String lastName,
                      @RequestParam String firstName) {
        return employeeService.addEmployee(lastName, firstName);
//        return String.format("Сотрудник % % успешно добавлен", lastName, firstName);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String lastName,
                      @RequestParam String firstName) {
        return employeeService.removeEmployee(lastName, firstName);
//        return String.format("Сотрудник % % успешно удален", lastName, firstName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String lastName,
                      @RequestParam String firstName) {
        return employeeService.findEmployee(lastName, firstName);
 //       return String.format("Сотрудник % % найден", lastName, firstName);
    }
    @GetMapping()
    public Collection<Employee> allEmployees() {
        return (Collection<Employee>) employeeService.all();
    }
}
