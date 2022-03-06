package dao;

import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    static final String SELECT_ACCOUNT = "SELECT * FROM USER WHERE username = ? and password = ?";
    public Account checkLogin(String username, String password) {
        Account account = null;
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ACCOUNT);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                account = new Account(resultSet.getString("username"), resultSet.getString("password"));
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return account;
    }
}
