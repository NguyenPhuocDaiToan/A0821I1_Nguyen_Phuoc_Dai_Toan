package service;


import dao.UserDAO;
import model.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public List<User> getAll() {
        return userDAO.getAll();
    }
}
