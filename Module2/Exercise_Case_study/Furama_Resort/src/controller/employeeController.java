package controller;

import model.Employee;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private static EmployeeService employeeService = new EmployeeServiceImpl();
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    public void save(Employee e) {
        employeeService.save(e);
    }

    public boolean delete(int id) {
        return employeeService.delete(id);
    }
}
