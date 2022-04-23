package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "daitoan2002";

    //    USER
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select * from users where id = ?";
    private static final String SELECT_USER_BY_COUNTRY = "select * from users where country = ?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?, email= ?, country =? where id = ?;";
    private static final String SEARCH_USER = "select * from users where name like ? and country like ?";

    //    EMPLOYEE
    private static final String SQL_CREATE_TABLE_EMPLOYEE = "CREATE TABLE EMPLOYEE"
            + "("
            + "ID serial,"
            + "NAME varchar(100) not null,"
            + "SALARY numeric(15, 2) not null,"
            + "CREATE_DATE timestamp,"
            + "PRIMARY KEY(ID)"
            + ")";
    private static final String SQL_DROP_TABLE_EMPLOYEE = "DROP TABLE IF EXISTS EMPLOYEE";
    private static final String SQL_INSERT_EMPLOYEE = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATE_DATE) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE_EMPLOYEE = "UPDATE EMPLOYEE SET SALARY = ? WHERE NAME = ?";


    protected Connection getConnection() {
        Connection connection = null;
        try {
            // Nạp trình điều khiển
            Class.forName("com.mysql.jdbc.Driver");
            // Tạo đối tượng kết nối
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    //    Select

    public User selectUser(int id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);)
        {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);)
        {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    //    Insert
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    //    Delete
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    //    Update
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);)
        {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public List<User> search(String name, String country) throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USER);){
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + country + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameUser = rs.getString("name");
                String emailUser = rs.getString("email");
                String countryUser = rs.getString("country");
                users.add(new User(id, nameUser, emailUser, countryUser));
            }
        }
        return users;
    }
    public List<User> findByCountry(String country) throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);){
            preparedStatement.setString(1, country);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameUser = rs.getString("name");
                String countryUser = rs.getString("country");
                String emailUser = rs.getString("email");
                users.add(new User(id, nameUser, emailUser, countryUser));
            }
        }
        return users;
    }

    public User getUserByID(int id) {
        User user = null;
        String query = "{CALL get_user_by_id(?)}";
        try (Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(query);){
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
