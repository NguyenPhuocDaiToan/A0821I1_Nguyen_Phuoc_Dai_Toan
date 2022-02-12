import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String desc = request.getParameter("desc");
        float price = Float.parseFloat(request.getParameter("price"));
        float discountPercent = Float.parseFloat(request.getParameter("discountPercent"));

        float discountAmount = (float) (price * discountPercent * 0.01);
        float discountPrice = price - discountAmount;
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h1>Product Description: </h1>" + desc);
        printWriter.println("<h1>Discount Amount: </h1>" + discountAmount);
        printWriter.println("<h1>Discount Price: </h1>" + discountPrice);
        printWriter.println("</html>");
    }
}
