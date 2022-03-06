package dao;

import model.Employee;
import model.EmployeeDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final String SELECT_EMPLOYEE_DTO = "select e.employee_id, e.employee_name, e.employee_birthday, e.employee_id_card, " +
            "e.employee_salary, e.employee_phone, e.employee_email, e.employee_address, p.position_id, p.position_name, ed.education_degree_id, " +
            "ed.education_degree_name, d.division_id, d.division_name, us.username from employee e\n" +
            "join `position` p on e.position_id = p.position_id\n" +
            "join education_degree ed on ed.education_degree_id = e.education_degree_id\n" +
            "join division d on e.division_id = d.division_id \n" +
            "join user us on e.username = us.username\n" +
            "order by e.employee_id;";
    private final String DELETE_EMPLOYEE = "delete from employee where employee_id = ?";
    private final String SELECT_BY_ID = "select e.employee_id, e.employee_name, e.employee_birthday, e.employee_id_card, " +
            "e.employee_salary, e.employee_phone, e.employee_email, e.employee_address, p.position_id, p.position_name, ed.education_degree_id, " +
            "ed.education_degree_name, d.division_id, d.division_name, us.username from employee e\n" +
            "join `position` p on e.position_id = p.position_id\n" +
            "join education_degree ed on ed.education_degree_id = e.education_degree_id\n" +
            "join division d on e.division_id = d.division_id \n" +
            "join user us on e.username = us.username\n" +
            "where e.employee_id = ?";

    private final String UPDATE_EMPLOYEE = "update employee set employee_name = ?, employee_birthday = ?, employee_id_card = ?," +
            "employee_salary = ?, employee_phone = ?,  employee_email = ?, employee_address = ?, position_id = ?, " +
            "education_degree_id = ?, division_id = ? where employee_id = ?";
    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public EmployeeDTO selectByIdDTO(int id) {
        EmployeeDTO employeeDTO = null;
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                String birthday = resultSet.getString(3);
                String card = resultSet.getString(4);
                double salary = resultSet.getDouble(5);
                String phone = resultSet.getString(6);
                String email = resultSet.getString(7);
                String address = resultSet.getString(8);
                int position_id = resultSet.getInt("position_id");
                String position_name = resultSet.getString("position_name");
                int education_degree_id = resultSet.getInt("education_degree_id");
                String education_degree_name = resultSet.getString("education_degree_name");
                int division_id = resultSet.getInt("division_id");
                String division_name = resultSet.getString("division_name");
                String username = resultSet.getString("username");
                employeeDTO = new EmployeeDTO(id, name, birthday, card, salary, phone, email, address, position_id, position_name,
                        education_degree_id, education_degree_name, division_id, division_name, username);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllDTO() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_EMPLOYEE_DTO);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String birthday = resultSet.getString(3);
                String card = resultSet.getString(4);
                double salary = resultSet.getDouble(5);
                String phone = resultSet.getString(6);
                String email = resultSet.getString(7);
                String address = resultSet.getString(8);
                int position_id = resultSet.getInt("position_id");
                String position_name = resultSet.getString("position_name");
                int education_degree_id = resultSet.getInt("education_degree_id");
                String education_degree_name = resultSet.getString("education_degree_name");
                int division_id = resultSet.getInt("division_id");
                String division_name = resultSet.getString("division_name");
                String username = resultSet.getString("username");
                employeeDTOList.add(new EmployeeDTO(id, name, birthday, card, salary, phone, email, address, position_id, position_name,
                        education_degree_id, education_degree_name, division_id, division_name, username));
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeDTOList;
    }

    @Override
    public boolean add(Employee employee) {
        return false;
    }

    @Override
    public boolean edit(Employee employee) {
        boolean checkSuccess = false;
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setInt(11, employee.getId());
            checkSuccess = preparedStatement.executeUpdate() > 0;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return checkSuccess;
    }

    @Override
    public boolean delete(int id) {
        boolean checkSuccess = false;
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id);
            checkSuccess = preparedStatement.executeUpdate() > 0;
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return checkSuccess;
    }

    @Override
    public List<Employee> search(String value) {
        return null;
    }

    @Override
    public List<EmployeeDTO> searchDTO(String value) {
        return null;
    }
}
