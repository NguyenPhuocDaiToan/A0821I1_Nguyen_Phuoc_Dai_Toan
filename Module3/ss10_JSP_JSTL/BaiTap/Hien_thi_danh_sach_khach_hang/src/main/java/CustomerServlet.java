import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    public static ArrayList<Customer> customers = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        customers.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "img/Mai_Van_Hoan.jpg"));
        customers.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "img/Mai_Van_Hoan.jpg"));
        customers.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "img/Mai_Van_Hoan.jpg"));
        customers.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "img/Mai_Van_Hoan.jpg"));
        customers.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "img/Mai_Van_Hoan.jpg"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/listCustomer.jsp");
        request.setAttribute("customers", customers);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/listCustomer.jsp");
        request.setAttribute("customers", customers);
        requestDispatcher.forward(request, response);
    }
}
