package service;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;
import model.EmployeeDTO;

import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    public List<EmployeeDTO> getAllDTO() {
        return employeeDAO.getAllDTO();
    }
    public EmployeeDTO selectByIdDTO(int id) {
        return employeeDAO.selectByIdDTO(id);
    }
    public boolean delete(int id) {
        return employeeDAO.delete(id);
    }
    public boolean edit(Employee employee) {
        return employeeDAO.edit(employee);
    }
}
