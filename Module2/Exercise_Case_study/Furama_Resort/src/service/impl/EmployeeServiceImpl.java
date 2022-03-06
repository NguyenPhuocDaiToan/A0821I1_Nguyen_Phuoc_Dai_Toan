package service.impl;

import model.Employee;
import service.BaseService;
import service.EmployeeService;
import util.CSVHelper;
import util.ConstantUtil.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employees = new ArrayList<>();
    private static CSVHelper<Employee> csvHelper = new CSVHelper<>();

    public EmployeeServiceImpl() {
        getFromFile();
    }

    @Override
    public List<Employee> getAll() {
        if(employees.size() == 0)   getFromFile();
        return employees;
    }

    public static void getFromFile() {
        List<String> lines = csvHelper.read(PATH.EMPLOYEE);
        if(lines.get(0).equals("")) {
            return;
        }

        for(String line : lines) {
            String[] tmp = line.split(",");
            int id = Integer.parseInt(tmp[0]);
            String code = tmp[1];
            String fullName = tmp[2];
            String gender = tmp[3];
            String birthday = tmp[4];
            String phone = tmp[5];
            String email = tmp[6];
            String address = tmp[7];
            String degree = tmp[8];
            String position = tmp[9];
            double salary = Double.parseDouble(tmp[10]);
            Employee employee = new Employee(0, code, fullName, Gender.valueOf(gender), birthday, phone, email
                    , address, Degree.valueOf(degree), Position.valueOf(position), salary);
            employees.add(employee);
        }
    }

    @Override
    public void save(Employee e) {
        // create
        if(e.getId() == 0) {
            int id = (employees.size() == 0) ? 1 : employees.get(employees.size() - 1).getId() + 1;
            e.setId(id);
            employees.add(e);
            List<Employee> tmp = new ArrayList<>();
            tmp.add(e);
            csvHelper.write(tmp, PATH.EMPLOYEE, true);
        }
        // edit
        else {
            employees.set(employees.indexOf(e), e);
            csvHelper.write(employees, PATH.EMPLOYEE, false);
        }
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
