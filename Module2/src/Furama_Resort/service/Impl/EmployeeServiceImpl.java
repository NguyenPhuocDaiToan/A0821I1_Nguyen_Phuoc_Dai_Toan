package Furama_Resort.service.Impl;

import Furama_Resort.models.Employee;
import Furama_Resort.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employees = new ArrayList<>();

    public void save(Employee e) {
        if(e.getId() == 0) {
            e.setId(employees.size() + 1);
            employees.add(e);
        }
        else {
            int size = employees.size();
            for(int i = 0; i < size; i++) {
                if(employees.get(i).getId() == e.getId()) {
                    employees.set(i, e);
                    break;
                }
            }
        }
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public int delete() {
        return 0;
    }

    public void display() {
        for(Employee e : employees) {
            System.out.println(e);
        }
    }
}
