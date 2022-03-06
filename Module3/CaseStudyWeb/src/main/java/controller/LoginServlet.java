package controller;

import dao.LoginDAO;
import model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private LoginDAO loginDAO = new LoginDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("password");

        Account account = loginDAO.checkLogin(username, password);
        if(account == null) {
            response.sendRedirect("login.jsp");
        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            response.sendRedirect("/employee");
        }
    }
}
