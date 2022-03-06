package dao;


import model.Division;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionDAO {
    private final String SELECT_DIVISION = "SELECT * FROM DIVISION";

    public List<Division> getAll() {
        List<Division> divisions = new ArrayList<>();
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_DIVISION);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                divisions.add(new Division(id, name));
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisions;
    }
}
