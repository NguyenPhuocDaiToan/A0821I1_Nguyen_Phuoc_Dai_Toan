package dao;

import model.EducationDegree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeDAO {
    private final String SELECT_EDUCATION_DEGREE = "SELECT * FROM EDUCATION_DEGREE";

    public List<EducationDegree> getAll() {
        List<EducationDegree> educationDegrees = new ArrayList<>();
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_EDUCATION_DEGREE);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                educationDegrees.add(new EducationDegree(id, name));
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegrees;
    }
}
