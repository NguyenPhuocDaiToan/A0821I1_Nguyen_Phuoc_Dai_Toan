package service;

import dao.UserDao;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDao userDAO = new UserDao();

    public void insertUser(User user) throws SQLException {
        userDAO.insertUser(user);
    }

    public User selectUser(int id) {
        return userDAO.selectUser(id);
    }

    public List<User> selectAllUsers() {
        return userDAO.selectAllUsers();
    }


    public boolean deleteUser(int id) throws  SQLException {
        return userDAO.deleteUser(id);
    }

    public boolean updateUser(User user) throws SQLException {
        return userDAO.updateUser(user);
    }

    public List<User> search(String name, String country) throws SQLException {
        return userDAO.search(name, country);
    }
    public List<User> findByCountry(String country) throws SQLException {
        return userDAO.findByCountry(country);
    }

    public User getUserByID(int id) {
        return userDAO.getUserByID(id);
    }

}
