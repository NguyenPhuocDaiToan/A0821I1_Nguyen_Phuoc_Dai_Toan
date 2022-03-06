package dao;


import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private final String SELECT_USER = "SELECT username FROM USER";

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_USER);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                String username = resultSet.getString(1);
                String pass = resultSet.getString(2);
                users.add(new User(username, pass));
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}
