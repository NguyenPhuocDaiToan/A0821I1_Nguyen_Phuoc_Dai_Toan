package dao;

import model.Employee;
import model.EmployeeDTO;

import java.util.List;


public interface EmployeeDAO extends BaseDAO<Employee> {
    EmployeeDTO selectByIdDTO(int id);
    List<EmployeeDTO> getAllDTO();
    List<EmployeeDTO> searchDTO(String value);
}
