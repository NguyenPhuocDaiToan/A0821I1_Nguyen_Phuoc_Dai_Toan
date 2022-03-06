package controller;

import model.*;
import service.DivisionService;
import service.EducationDegreeService;
import service.EmployeeService;
import service.PositionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();
    private PositionService positionService = new PositionService();
    private DivisionService divisionService = new DivisionService();
    private EducationDegreeService educationDegreeService = new EducationDegreeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null)  action = "";
        switch (action) {
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "":
                showListEmployee(request, response);
                break;
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null)  action = "";
        switch (action) {
            case "edit":
                editEmployee(request, response);
                break;

        }
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EmployeeDTO employee = employeeService.selectByIdDTO(id);
        List<Position> positions = positionService.getAll();
        List<Division> divisions = divisionService.getAll();
        List<EducationDegree> educationDegrees = educationDegreeService.getAll();
        request.setAttribute("id", id);
        request.setAttribute("employee", employee);
        request.setAttribute("positions", positions);
        request.setAttribute("divisions", divisions);
        request.setAttribute("educationDegrees", educationDegrees);
        request.setAttribute("username", employee.getUserName());
        request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String card = request.getParameter("card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        String username = request.getParameter("username");
        Employee employee = new Employee(id, name, birthday, card, salary, phone, email, address, positionId,
                divisionId, educationDegreeId, username);
        boolean checkSuccess = employeeService.edit(employee);
        String mess = (checkSuccess == true) ? "Update employee successful" : "Update employee failure";

        EmployeeDTO employeeDTO = employeeService.selectByIdDTO(id);
        List<Position> positions = positionService.getAll();
        List<Division> divisions = divisionService.getAll();
        List<EducationDegree> educationDegrees = educationDegreeService.getAll();
        request.setAttribute("id", id);
        request.setAttribute("employee", employeeDTO);
        request.setAttribute("positions", positions);
        request.setAttribute("divisions", divisions);
        request.setAttribute("educationDegrees", educationDegrees);
        request.setAttribute("username", employee.getUserName());
        request.setAttribute("mess", mess);
        request.getRequestDispatcher("editEmployee.jsp").forward(request, response);

    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean checkSuccess = employeeService.delete(id);
        response.sendRedirect("/employee");
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EmployeeDTO> employees = employeeService.getAllDTO();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("listEmployee.jsp").forward(request, response);
    }
}
